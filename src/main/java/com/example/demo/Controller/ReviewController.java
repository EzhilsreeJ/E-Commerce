package com.example.demo.Controller;

import com.example.demo.Model.Review;
import com.example.demo.Service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    // Constructor injection (best practice)
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // CREATE
    @PostMapping("/add")
    public Review addReview(@RequestBody Review review) {
        return reviewService.addReview(review);
    }

    // READ ALL
    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable Long id) {
        return reviewService.getReviewById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Review addOrUpdateReview(@PathVariable Long id, @RequestBody Review review) {
        review.setId(id);
        return reviewService.addOrUpdateReview(review);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return "Review deleted successfully";
    }
}
