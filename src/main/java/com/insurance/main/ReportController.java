package com.insurance.main;

import com.insurance.main.model.Report;
import com.insurance.main.repository.ReportRepository; // Ensure this matches the actual package of ReportRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportRepository reportRepository; // Use the repository directly

    @GetMapping("/{id}")
    public String getReport(@PathVariable String id, Model model) {
        Report report = reportRepository.findById(id).orElse(null); // Fetch the report from the repository
        if (report == null) {
            return "error/404"; // Redirect or show an error page if no report is found
        }
        model.addAttribute("insuranceForm", report);
        return "report"; // This should match the name of your Thymeleaf template
    }

    @PostMapping("/edit")
    public String editReport(@ModelAttribute Report report) {
        reportRepository.save(report); // Save or update the report using the repository
        return "redirect:/report/" + report.getId();
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<String> deleteReport(@PathVariable String id) {
        if (reportRepository.existsById(id)) {
            reportRepository.deleteById(id); // Delete the report using the repository
            return ResponseEntity.ok("Success");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Report not found");
        }
    }

    @GetMapping("/export/excel/{id}")
    public void exportToExcel(@PathVariable String id, HttpServletResponse response) throws IOException {
        Report report = reportRepository.findById(id).orElse(null); // Fetch the report from the repository
        
        if (report == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Report not found");
            return;
        }
        
        // Set the content type and header for the response
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=report_" + id + ".xlsx";
        response.setHeader(headerKey, headerValue);
        
        // Export the report to Excel
        // You'll need to implement the method to actually generate and write the Excel file
        exportReportToExcel(report, response); 
    }

    private void exportReportToExcel(Report report, HttpServletResponse response) throws IOException {
        // Implement logic to export the report to an Excel file
        // This may involve using a library like Apache POI
        // Example code to be added here
    }
}