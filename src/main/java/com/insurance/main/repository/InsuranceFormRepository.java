package com.insurance.main.repository;

import com.insurance.main.model.InsuranceForm;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InsuranceFormRepository extends MongoRepository<InsuranceForm, String> {
    // Additional query methods (if needed) can be defined here
}
