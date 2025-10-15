package com.example.branchchecklist.service;

import com.example.branchchecklist.model.ChecklistEntry;
import com.example.branchchecklist.model.Branch;
import com.example.branchchecklist.repository.ChecklistRepository;
import com.example.branchchecklist.util.AESUtil;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ChecklistService {
    private final ChecklistRepository repo;
    private final AESUtil aesUtil;
    public ChecklistService(ChecklistRepository repo, AESUtil aesUtil) {
        this.repo = repo;
        this.aesUtil = aesUtil;
    }

    public ChecklistEntry saveChecklist(String mobile, Branch branch, String section, String item, String remarks, String imageBase64) throws Exception {
        ChecklistEntry e = new ChecklistEntry();
        e.setMobileEncrypted(aesUtil.encrypt(mobile));
        e.setBranchIdEncrypted(aesUtil.encrypt(branch.getId()));
        e.setBranchNameEncrypted(aesUtil.encrypt(branch.getName()));
        e.setSolIdEncrypted(aesUtil.encrypt(branch.getSolId()));
        e.setSectionEncrypted(aesUtil.encrypt(section));
        e.setItemEncrypted(aesUtil.encrypt(item));
        e.setRemarksEncrypted(aesUtil.encrypt(remarks));
        e.setImageEncrypted(aesUtil.encrypt(imageBase64 == null ? "" : imageBase64));
        e.setCreatedAt(Instant.now());
        return repo.save(e);
    }
}
