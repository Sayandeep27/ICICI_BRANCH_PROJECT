package com.example.branchchecklist.repository;

import com.example.branchchecklist.model.Branch;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BranchRepository extends MongoRepository<Branch, String> {
}
