package com.insurance.main.repository;

import com.insurance.main.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends MongoRepository<User, String> {
    boolean existsByEmail(String email); // Check if email is already registered
    User findByEmail(String email); // Find user by email
}
