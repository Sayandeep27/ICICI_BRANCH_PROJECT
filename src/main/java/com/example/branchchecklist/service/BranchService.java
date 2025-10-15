package com.example.branchchecklist.service;

import com.example.branchchecklist.model.Branch;
import com.example.branchchecklist.repository.BranchRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {
    private final BranchRepository repo;

    public BranchService(BranchRepository repo) {
        this.repo = repo;
    }

    public List<Branch> getAll() {
        return repo.findAll();
    }

    public Branch getById(String id) {
        return repo.findById(id).orElse(null);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void seed() {
        if (repo.count() == 0) {
            repo.save(new Branch("Mumbai Main", "SOL001"));
            repo.save(new Branch("Delhi Central", "SOL002"));
            repo.save(new Branch("Bengaluru East", "SOL003"));
        }
    }
}
