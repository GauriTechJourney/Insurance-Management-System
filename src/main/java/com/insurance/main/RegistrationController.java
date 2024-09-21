package com.insurance.main;

import com.insurance.main.repository.InsuranceRepository;
import com.insurance.main.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private InsuranceRepository insuranceRepository;

    private static final String UPLOAD_DIR = "uploads/";

    @GetMapping
    public String showRegistrationForm() {
        return "register"; // This should match the filename of your registration HTML in the 'static' directory
    }

    @PostMapping
    public RedirectView registerUser(
            @RequestParam String firstName,
            @RequestParam(required = false) String middleName,
            @RequestParam String lastName,
            @RequestParam String mobileNumber,
            @RequestParam("photo") MultipartFile photo,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String confirmPassword
    ) throws IOException {

        if (!password.equals(confirmPassword)) {
            return new RedirectView("/register?error=password_mismatch");
        }

        if (!Pattern.matches("^[0-9]{10}$", mobileNumber)) {
            return new RedirectView("/register?error=invalid_mobile_number");
        }

        if (photo.isEmpty() || !Pattern.compile("image/(jpeg|jpg|png)", Pattern.CASE_INSENSITIVE).matcher(photo.getContentType()).matches() || photo.getSize() > 1048576) {
            return new RedirectView("/register?error=invalid_photo");
        }

        if (insuranceRepository.existsByEmail(email)) {
            return new RedirectView("/register?error=email_exists");
        }

        // Ensure upload directory exists
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        Path photoPath = Paths.get(UPLOAD_DIR, photo.getOriginalFilename());
        Files.write(photoPath, photo.getBytes());

        User user = new User();
        user.setFirstname(firstName);
        user.setMiddlename(middleName);
        user.setLastname(lastName);
        user.setMobilenumber(mobileNumber);
        user.setEmail(email);
        user.setPassword(hashPassword(password)); // Store hashed password
        user.setPhoto(photo.getOriginalFilename());

        insuranceRepository.save(user);

        return new RedirectView("/login.html"); // Assuming you are using '/login' as your login URL
    }

    private String hashPassword(String password) throws IOException {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new IOException("Error hashing password", e);
        }
    }
}
