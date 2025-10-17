package com.example.branchchecklist.controller;

import com.example.branchchecklist.model.Review;
import com.example.branchchecklist.service.ReviewService;
import org.springframework.http.HttpStatus;
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

    @PostMapping
    public ResponseEntity<?> submitReview(@RequestBody Review review) {
        try {
            Review saved = reviewService.saveReview(review);
            return ResponseEntity.ok(saved);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{branchId}")
    public List<Review> getReviewsByBranch(@PathVariable String branchId) {
        return reviewService.getReviewsByBranch(branchId);
    }
}
