package com.example.branchchecklist.service;

import com.example.branchchecklist.model.Branch;
import com.example.branchchecklist.model.Review;
import com.example.branchchecklist.repository.BranchRepository;
import com.example.branchchecklist.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final BranchRepository branchRepository;

    public ReviewService(ReviewRepository reviewRepository, BranchRepository branchRepository) {
        this.reviewRepository = reviewRepository;
        this.branchRepository = branchRepository;
    }

    /**
     * Save a review after validating the branch.
     * Automatically attaches branchName and solId if missing.
     */
    public Review saveReview(Review review) {
        // Validate that the branchId exists in MongoDB
        Optional<Branch> branchOpt = branchRepository.findById(review.getBranchId());
        if (branchOpt.isEmpty()) {
            throw new IllegalArgumentException("Invalid branchId: Branch not found in database");
        }

        Branch branch = branchOpt.get();

        // Auto-fill branchName and solId if not provided
        if (review.getBranchName() == null || review.getBranchName().isEmpty()) {
            review.setBranchName(branch.getBranchName());
        }

        if (review.getSolId() == null || review.getSolId().isEmpty()) {
            review.setSolId(branch.getSolId());
        }

        // Save review in MongoDB
        return reviewRepository.save(review);
    }

    /**
     * Fetch all reviews for a given branch ID.
     */
    public List<Review> getReviewsByBranch(String branchId) {
        return reviewRepository.findByBranchId(branchId);
    }

    /**
     * Fetch all reviews (useful for admin or testing)
     */
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    /**
     * Delete a review by ID (optional, for admin panel or testing)
     */
    public void deleteReview(String reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}
