package com.example.branchchecklist.controller;

import com.example.branchchecklist.model.Review;
import com.example.branchchecklist.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // Save review (remarks + base64 photo)
    @PostMapping
    public ResponseEntity<Review> submitReview(@RequestBody Review review) {
        Review saved = reviewService.saveReview(review);
        return ResponseEntity.ok(saved);
    }

    // Get all reviews for a branch
    @GetMapping("/{branchId}")
    public ResponseEntity<List<Review>> getReviewsByBranch(@PathVariable String branchId) {
        List<Review> reviews = reviewService.getReviewsByBranch(branchId);
        return ResponseEntity.ok(reviews);
    }
}
