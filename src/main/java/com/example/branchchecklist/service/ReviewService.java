package com.example.branchchecklist.service;

import com.example.branchchecklist.model.Review;
import com.example.branchchecklist.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review saveReview(String branchId, String reviewText, String imageBase64) {
        Review review = new Review(branchId, reviewText, imageBase64);
        return reviewRepository.save(review);
    }

    public List<Review> getReviewsByBranch(String branchId) {
        return reviewRepository.findByBranchId(branchId);
    }
}
