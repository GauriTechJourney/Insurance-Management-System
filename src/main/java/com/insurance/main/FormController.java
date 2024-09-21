package com.insurance.main;

import com.insurance.main.model.InsuranceForm;
import com.insurance.main.repository.InsuranceFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.validation.Valid;
import java.util.Optional;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@Controller
@RequestMapping("/form")
public class FormController {

    @Autowired
    private InsuranceFormRepository insuranceFormRepository;

    // Show the insurance form
    @GetMapping
    public String showInsuranceForm(Model model) {
        model.addAttribute("insuranceForm", new InsuranceForm());
        return "form"; // Points to the form.html template
    }

    // Submit the insurance form
    @PostMapping
    public RedirectView submitInsuranceForm(@Valid InsuranceForm insuranceForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return new RedirectView("/form?error=validation_error");
        }

        // Auto-generate Policy Number (example logic)
        insuranceForm.setPolicyNumber("POL" + System.currentTimeMillis());

        // Save the form to the MongoDB database
        insuranceFormRepository.save(insuranceForm);

        // Redirect to the report page with the saved ID
        redirectAttributes.addAttribute("id", insuranceForm.getId());
        return new RedirectView("/report.html");
    }

    // Show the report page with the retrieved data
    @GetMapping("/report")
    public String getReport(@RequestParam("id") String id, Model model) {
        Optional<InsuranceForm> insuranceFormOptional = insuranceFormRepository.findById(id);

        if (insuranceFormOptional.isPresent()) {
            model.addAttribute("insuranceForm", insuranceFormOptional.get());
        } else {
            // Handle the case where the ID is not found
            return "error"; // Redirect to an error page or handle accordingly
        }

        return "report"; // Points to the report.html template
    }

    // Show the form with pre-filled data for editing
    @GetMapping("/edit")
    public String editForm(@RequestParam("id") String id, Model model) {
        Optional<InsuranceForm> insuranceFormOptional = insuranceFormRepository.findById(id);

        if (insuranceFormOptional.isPresent()) {
            model.addAttribute("insuranceForm", insuranceFormOptional.get());
            return "form"; // Reuse the form.html template for editing
        } else {
            // Handle the case where the ID is not found
            return "error"; // Redirect to an error page or handle accordingly
        }
    }

    // Delete the insurance form entry
    @PostMapping("/delete")
    public RedirectView deleteInsurance(@RequestParam("id") String id, RedirectAttributes redirectAttributes) {
        insuranceFormRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Insurance form deleted successfully.");
        return new RedirectView("/form");
    }

    // Export the data to Excel
    @GetMapping("/export")
    public void exportToExcel(@RequestParam("id") String id, HttpServletResponse response) {
        Optional<InsuranceForm> insuranceFormOptional = insuranceFormRepository.findById(id);

        if (insuranceFormOptional.isPresent()) {
            InsuranceForm insuranceForm = insuranceFormOptional.get();

            // Set the content type and headers for Excel export
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=insurance_form_" + id + ".xls");

            try (PrintWriter writer = response.getWriter()) {
                // Write Excel data (simple CSV format for demonstration)
                writer.println("Field,Value");
                writer.println("Full Name," + insuranceForm.getFullName());
                writer.println("Address," + insuranceForm.getAddress());
                writer.println("Mobile Number," + insuranceForm.getMobileNumber());
                writer.println("Vehicle Number," + insuranceForm.getVehicleNumber());
                writer.println("Vehicle Model Number," + insuranceForm.getVehicleModelNumber());
                writer.println("Vehicle Manufacturer," + insuranceForm.getVehicleManufacturer());
                writer.println("Year Of Manufacture," + insuranceForm.getYearOfManufacture());
                writer.println("Vehicle Chassis Number," + insuranceForm.getVehicleChassisNumber());
                writer.println("Fuel Type," + insuranceForm.getFuelType());
                writer.println("Body Type," + insuranceForm.getBodyType());
                writer.println("Cubic Capacity," + insuranceForm.getCubicCapacity());
                writer.println("Vehicle Color," + insuranceForm.getVehicleColor());
                writer.println("Policy Receipt Number," + insuranceForm.getPolicyReceiptNumber());
                writer.println("Policy Number," + insuranceForm.getPolicyNumber());
                writer.println("Issuing Office Address," + insuranceForm.getIssuingOfficeAddress());
                writer.println("Issuing Office Phone Number," + insuranceForm.getIssuingOfficePhoneNumber());
                writer.println("Issuing Office Fax Number," + insuranceForm.getIssuingOfficeFaxNumber());
                writer.println("Issuing Office Email," + insuranceForm.getIssuingOfficeEmail());
                writer.println("Insurance Basic Amount," + insuranceForm.getInsuranceBasicAmount());
                writer.println("Basic TP Cover Amount," + insuranceForm.getBasicTPCoverAmount());
                writer.println("TP Premium Amount," + insuranceForm.getTpPremiumAmount());
                writer.println("Net Premium," + insuranceForm.getNetPremium());
                writer.println("Service Tax On Premium," + insuranceForm.getServiceTaxOnPremium());
                writer.println("Total Payable," + insuranceForm.getTotalPayable());
            } catch (IOException e) {
                e.printStackTrace();
                // Handle the exception
            }
        } else {
            // Handle the case where the ID is not found
            throw new RuntimeException("Insurance form not found for id: " + id);
        }
    }
}
