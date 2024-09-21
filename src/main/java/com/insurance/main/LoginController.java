package com.insurance.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import com.insurance.main.model.User;
import com.insurance.main.repository.InsuranceRepository;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final InsuranceRepository insuranceRepository;

    @Autowired
    public LoginController(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    @GetMapping
    public String showLoginForm() {
        return "login"; // This should match the filename of your login HTML in the 'static' directory
    }

    @PostMapping
    public String loginUser(@RequestParam String email, @RequestParam String password, Model model) {
        User user = insuranceRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            return "redirect:/form.html"; // Redirect to form.html page in the 'static' directory
        } else {
            model.addAttribute("loginError", "Invalid email or password. Please try again.");
            return "login";
        }
    }
}
