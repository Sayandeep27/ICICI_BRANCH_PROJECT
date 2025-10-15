package com.example.branchchecklist.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("branches")
public class Branch {
    @Id
    private String id;
    private String name;
    private String solId;
    public Branch() {}
    public Branch(String name, String solId) {
        this.name = name; this.solId = solId;
    }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSolId() { return solId; }
    public void setSolId(String solId) { this.solId = solId; }
}
