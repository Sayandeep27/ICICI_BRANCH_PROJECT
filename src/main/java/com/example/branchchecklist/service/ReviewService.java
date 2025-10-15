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

    // Save a review and return the saved object
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    // Fetch all reviews for a specific branch
    public List<Review> getReviewsByBranch(String branchId) {
        return reviewRepository.findByBranchId(branchId);
    }
}
