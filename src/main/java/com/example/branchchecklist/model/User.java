package com.example.branchchecklist.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
public class User {
    @Id
    private String id;
    private String mobile;
    public User() {}
    public User(String mobile) { this.mobile = mobile; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }
}
