package com.example.branchchecklist.repository;

import com.example.branchchecklist.model.ChecklistCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChecklistRepository extends MongoRepository<ChecklistCategory, String> {
    ChecklistCategory findBySection(String section);
}
