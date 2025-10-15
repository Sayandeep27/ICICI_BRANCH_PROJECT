package com.example.branchchecklist.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document("checklist_entries")
public class ChecklistEntry {
    @Id
    private String id;
    private String mobileEncrypted; // AES encrypted
    private String branchIdEncrypted;
    private String branchNameEncrypted;
    private String solIdEncrypted;
    private String sectionEncrypted;
    private String itemEncrypted;
    private String remarksEncrypted;
    private String imageEncrypted; // encrypted base64 string
    private Instant createdAt;

    public ChecklistEntry() {}

    // getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getMobileEncrypted() { return mobileEncrypted; }
    public void setMobileEncrypted(String mobileEncrypted) { this.mobileEncrypted = mobileEncrypted; }

    public String getBranchIdEncrypted() { return branchIdEncrypted; }
    public void setBranchIdEncrypted(String branchIdEncrypted) { this.branchIdEncrypted = branchIdEncrypted; }

    public String getBranchNameEncrypted() { return branchNameEncrypted; }
    public void setBranchNameEncrypted(String branchNameEncrypted) { this.branchNameEncrypted = branchNameEncrypted; }

    public String getSolIdEncrypted() { return solIdEncrypted; }
    public void setSolIdEncrypted(String solIdEncrypted) { this.solIdEncrypted = solIdEncrypted; }

    public String getSectionEncrypted() { return sectionEncrypted; }
    public void setSectionEncrypted(String sectionEncrypted) { this.sectionEncrypted = sectionEncrypted; }

    public String getItemEncrypted() { return itemEncrypted; }
    public void setItemEncrypted(String itemEncrypted) { this.itemEncrypted = itemEncrypted; }

    public String getRemarksEncrypted() { return remarksEncrypted; }
    public void setRemarksEncrypted(String remarksEncrypted) { this.remarksEncrypted = remarksEncrypted; }

    public String getImageEncrypted() { return imageEncrypted; }
    public void setImageEncrypted(String imageEncrypted) { this.imageEncrypted = imageEncrypted; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
