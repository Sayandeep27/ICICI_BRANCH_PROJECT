package com.example.branchchecklist.controller;

import com.example.branchchecklist.model.Review;
import com.example.branchchecklist.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/upload")
    public Map<String, Object> uploadReview(@RequestBody Map<String, String> request) {
        String branchId = request.get("branchId");
        String reviewText = request.get("review");
        String imageBase64 = request.get("imageBase64");

        Review saved = reviewService.saveReview(branchId, reviewText, imageBase64);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Review uploaded successfully");
        response.put("reviewId", saved.getId());
        return response;
    }

    @GetMapping("/{branchId}")
    public List<Review> getReviews(@PathVariable String branchId) {
        return reviewService.getReviewsByBranch(branchId);
    }
}
