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
    public Review updateReview(Review review) {
        Review existingReview = reviewRepository.findById(review.getId())
                .orElseThrow(() -> new RuntimeException("Review not found with id: " + review.getId()));

        existingReview.setRating(review.getRating());
        existingReview.setComment(review.getComment());
        existingReview.setUsers(review.getUsers());
        existingReview.setProduct(review.getProduct());
        existingReview.setOrders(review.getOrders());

        return reviewRepository.save(existingReview);
    }

    // DELETE
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
