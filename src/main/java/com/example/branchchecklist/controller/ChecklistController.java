package com.example.branchchecklist.controller;

import com.example.branchchecklist.dto.ChecklistSubmissionDto;
import com.example.branchchecklist.model.Branch;
import com.example.branchchecklist.service.BranchService;
import com.example.branchchecklist.service.ChecklistService;
import com.example.branchchecklist.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class ChecklistController {

    private final BranchService branchService;
    private final ChecklistService checklistService;
    private final JwtService jwtService;

    public ChecklistController(BranchService branchService, ChecklistService checklistService, JwtService jwtService) {
        this.branchService = branchService;
        this.checklistService = checklistService;
        this.jwtService = jwtService;
    }

    @GetMapping("/checklist")
    public String checklistPage(@RequestParam String branchId, @RequestParam String token, Model model) {
        Branch branch = branchService.getById(branchId);
        model.addAttribute("branch", branch);
        model.addAttribute("token", token);
        // sample items for each section; these are UI items that user may click on
        model.addAttribute("outsideItems", new String[] {"Signboard", "Entrance Steps", "Parking"});
        model.addAttribute("insideItems", new String[] {"Floor Cleanliness", "Counter Availability", "Lighting"});
        model.addAttribute("atmItems", new String[] {"ATM Machine Clean", "Security Guard", "Lighting"});
        return "checklist";
    }

    @PostMapping("/api/checklist/submit")
    @ResponseBody
    public ResponseEntity<?> submitChecklist(@RequestBody ChecklistSubmissionDto dto, Authentication auth) throws Exception {
        // mobile extracted from auth or dto
        String mobile = dto.getMobile();
        if (auth != null) {
            mobile = (String) auth.getPrincipal();
        }
        Branch branch = branchService.getById(dto.getBranchId());
        if (branch == null) return ResponseEntity.badRequest().body("Invalid branch");
        checklistService.saveChecklist(mobile, branch, dto.getSection(), dto.getItem(), dto.getRemarks(), dto.getImageBase64());
        return ResponseEntity.ok("Saved");
    }

    @GetMapping("/success")
    public String successPage() {
        return "success";
    }
}
