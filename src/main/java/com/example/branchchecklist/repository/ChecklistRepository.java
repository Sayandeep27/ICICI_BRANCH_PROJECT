package com.example.branchchecklist.repository;

import com.example.branchchecklist.model.ChecklistEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChecklistRepository extends MongoRepository<ChecklistEntry, String> {
}
