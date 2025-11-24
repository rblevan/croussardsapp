package fr.univ_poitiers.croussards.controller;

import fr.univ_poitiers.croussards.model.Review;
import fr.univ_poitiers.croussards.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/reviews")
    public Review addReview(@RequestBody Review review) {
        return reviewService.saveStudent(review);
    }

    @GetMapping("/reviews/{id}")
    public Optional<Review> getReview(@PathVariable Long id) {
        Optional<Review> review = reviewService.getReview(id);
        return review;
    }

    @GetMapping("/reviews")
    public List<Review> getReviews() {
        return reviewService.getReviews();
    }
}
