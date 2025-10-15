package com.example.branchchecklist.controller;

import com.example.branchchecklist.model.Review;
import com.example.branchchecklist.service.ReviewService;
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
    public Review submitReview(@RequestBody Review review) {
        return reviewService.saveReview(review);
    }

    // Get all reviews for a branch
    @GetMapping("/{branchId}")
    public List<Review> getReviewsByBranch(@PathVariable String branchId) {
        return reviewService.getReviewsByBranch(branchId);
    }
}
