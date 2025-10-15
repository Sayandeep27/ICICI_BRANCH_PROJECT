package com.example.branchchecklist.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("branches")
public class Branch {
    @Id
    private String id;
    private String branchName;
    private String solId;

    public Branch() {}

    public Branch(String branchName, String solId) {
        this.branchName = branchName;
        this.solId = solId;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getBranchName() { return branchName; }
    public void setBranchName(String branchName) { this.branchName = branchName; }

    public String getSolId() { return solId; }
    public void setSolId(String solId) { this.solId = solId; }
}
