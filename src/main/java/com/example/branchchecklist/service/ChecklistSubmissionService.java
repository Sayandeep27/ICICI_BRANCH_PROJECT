package com.example.branchchecklist.service;

import com.example.branchchecklist.model.ChecklistSubmission;
import com.example.branchchecklist.repository.ChecklistSubmissionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChecklistSubmissionService {

    private final ChecklistSubmissionRepository repository;

    public ChecklistSubmissionService(ChecklistSubmissionRepository repository) {
        this.repository = repository;
    }

    public ChecklistSubmission saveChecklist(ChecklistSubmission checklist) {
        return repository.save(checklist);
    }

    public ChecklistSubmission getChecklistByBranch(String branchId) {
        Optional<ChecklistSubmission> result = repository.findByBranchId(branchId);
        return result.orElse(null);
    }

    public Iterable<ChecklistSubmission> getAllChecklists() {
        return repository.findAll();
    }
}
