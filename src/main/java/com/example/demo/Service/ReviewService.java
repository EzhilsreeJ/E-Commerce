package com.example.demo.Service;

import com.example.demo.Model.Review;
import com.example.demo.Repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    // Constructor injection
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    // CREATE
    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

    // READ ALL
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // READ BY ID
    public Review getReviewById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found with id: " + id));
    }

    // UPDATE
    public Review addOrUpdateReview(Review review) {
        Long userId = review.getUsers().getId();
        Long productId = review.getProduct().getId();

<<<<<<< HEAD
        Review existing = reviewRepository
                .findByUsers_IdAndProduct_Id(userId, productId)
                .orElse(null);
=======
        existingReview.setRating(review.getRating());
        existingReview.setComment(review.getComment());
        existingReview.setUsers(review.getUsers());
        existingReview.setProduct(review.getProduct());
        existingReview.setOrder(review.getOrder());
>>>>>>> 1957c4b6ff9e5403bcb8d45ec6c576c1065d3e5b

        if (existing != null) {
            existing.setRating(review.getRating());
            existing.setComment(review.getComment());
            return reviewRepository.save(existing);
        }

        return reviewRepository.save(review);
    }


    // DELETE
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
