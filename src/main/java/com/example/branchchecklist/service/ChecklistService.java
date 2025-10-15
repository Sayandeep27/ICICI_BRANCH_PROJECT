package com.example.branchchecklist.service;

import com.example.branchchecklist.model.ChecklistCategory;
import com.example.branchchecklist.repository.ChecklistRepository;
import org.springframework.stereotype.Service;

@Service
public class ChecklistService {
    private final ChecklistRepository repository;

    public ChecklistService(ChecklistRepository repository) {
        this.repository = repository;
    }

    public ChecklistCategory getChecklistBySection(String section) {
        return repository.findBySection(section);
    }
}
