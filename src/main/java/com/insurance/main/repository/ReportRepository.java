package com.insurance.main.repository;

import com.insurance.main.model.Report;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends MongoRepository<Report, String> {
    
    // Custom query methods can be defined here if needed

    // Example: Find reports by vehicle number
    List<Report> findByVehicleNumber(String vehicleNumber);
    
    // Example: Find reports by policy number
    List<Report> findByPolicyNumber(String policyNumber);
}