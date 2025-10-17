package com.example.branchchecklist.repository;

import com.example.branchchecklist.model.Branch;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface BranchRepository extends MongoRepository<Branch, String> {
    Optional<Branch> findByBranchName(String branchName);
}
