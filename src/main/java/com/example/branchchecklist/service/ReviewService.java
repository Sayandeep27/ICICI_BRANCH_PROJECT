package com.example.branchchecklist.service;

import com.example.branchchecklist.model.Review;
import com.example.branchchecklist.repository.ReviewRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository repository;

    public ReviewService(ReviewRepository repository) {
        this.repository = repository;
    }

    public Review saveReview(Review review) {
        return repository.save(review);
    }

    public List<Review> getReviewsByBranch(String branchId) {
        return repository.findByBranchId(branchId);
    }
}
