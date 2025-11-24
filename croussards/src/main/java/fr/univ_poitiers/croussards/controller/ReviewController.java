package fr.univ_poitiers.croussards.controller;

import fr.univ_poitiers.croussards.model.Review;
import fr.univ_poitiers.croussards.repository.ReviewRepository;
import fr.univ_poitiers.croussards.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class ReviewController {
    @Autowired
    private ReviewRepository reviewRepository;

    @PostMapping("/reviews")
    public Review addReview(@RequestBody Review review) {
        return reviewRepository.save(review);
    }

    @GetMapping("/reviews/{id}")
    public Review getReview(@PathVariable Long id) {
        Optional<Review> review = ReviewService.getReview(id);
        return review.orElse(null);
    }

    @GetMapping("/reviews")
    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }
}
