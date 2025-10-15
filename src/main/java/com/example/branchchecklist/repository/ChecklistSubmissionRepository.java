package com.example.branchchecklist.repository;

import com.example.branchchecklist.model.ChecklistSubmission;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface ChecklistSubmissionRepository extends MongoRepository<ChecklistSubmission, String> {
    Optional<ChecklistSubmission> findByBranchId(String branchId);
}
