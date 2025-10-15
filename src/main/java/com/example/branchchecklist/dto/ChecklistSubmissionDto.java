package com.example.branchchecklist.dto;

public class ChecklistSubmissionDto {
    private String section; // Outside / Inside / ATM Lobby
    private String item; // which item selected
    private String remarks;
    private String imageBase64; // base64 string (data:image/...)
    private String branchId;
    private String mobile;

    // getters + setters
    public String getSection() { return section; }
    public void setSection(String section) { this.section = section; }
    public String getItem() { return item; }
    public void setItem(String item) { this.item = item; }
    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }
    public String getImageBase64() { return imageBase64; }
    public void setImageBase64(String imageBase64) { this.imageBase64 = imageBase64; }
    public String getBranchId() { return branchId; }
    public void setBranchId(String branchId) { this.branchId = branchId; }
    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }
}
