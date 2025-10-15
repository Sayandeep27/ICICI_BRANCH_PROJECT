package com.example.branchchecklist.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("reviews")
public class Review {
    @Id
    private String id;
    private String branchId;
    private String section;
    private String category;
    private String item;
    private String remarks;
    private String photoBase64;

    // getters and setters
}
