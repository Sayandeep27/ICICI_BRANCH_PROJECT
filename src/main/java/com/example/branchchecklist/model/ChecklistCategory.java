package com.example.branchchecklist.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document("checklist_categories")
public class ChecklistCategory {
    @Id
    private String id;
    private String section; // Outside, Inside, ATM Lobby
    private List<Category> categories;

    public static class Category {
        private String title;
        private List<String> subItems;

        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }

        public List<String> getSubItems() { return subItems; }
        public void setSubItems(List<String> subItems) { this.subItems = subItems; }
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getSection() { return section; }
    public void setSection(String section) { this.section = section; }

    public List<Category> getCategories() { return categories; }
    public void setCategories(List<Category> categories) { this.categories = categories; }
}
