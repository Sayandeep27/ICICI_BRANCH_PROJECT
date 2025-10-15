package com.example.branchchecklist.controller;

import com.example.branchchecklist.model.ChecklistSubmission;
import com.example.branchchecklist.service.ChecklistSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/checklist-section") // ✅ Unique base path to avoid conflicts
public class ChecklistSubmissionController {

    @Autowired
    private ChecklistSubmissionService service;

    // ✅ API to submit a checklist section (with reviews + image)
    @PostMapping("/submit")
    public Map<String, Object> submitChecklist(@RequestBody ChecklistSubmission checklist) {
        ChecklistSubmission saved = service.saveChecklist(checklist);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Checklist submitted successfully");
        response.put("id", saved.getId());

        return response;
    }

    // ✅ API to fetch checklist by branch ID (for viewing data)
    @GetMapping("/{branchId}")
    public ChecklistSubmission getChecklistByBranch(@PathVariable String branchId) {
        return service.getChecklistByBranch(branchId);
    }

    // ✅ API to list all submissions (for admin or review)
    @GetMapping("/all")
    public Iterable<ChecklistSubmission> getAllChecklists() {
        return service.getAllChecklists();
    }
}
