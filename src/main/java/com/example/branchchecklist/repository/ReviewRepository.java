package com.example.branchchecklist.repository;

import com.example.branchchecklist.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ReviewRepository extends MongoRepository<Review, String> {
    List<Review> findByBranchId(String branchId);
}
