package com.example.branchchecklist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.WebApplicationType;

@SpringBootApplication
public class BranchChecklistApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BranchChecklistApplication.class);
        app.setWebApplicationType(WebApplicationType.SERVLET); // Force web environment
        app.run(args);
        System.out.println("✅ Branch Checklist Application is running on http://localhost:8080");
    }
}
