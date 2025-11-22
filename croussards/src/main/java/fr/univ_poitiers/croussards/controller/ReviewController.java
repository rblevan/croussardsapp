package fr.univ_poitiers.croussards.controller;

import fr.univ_poitiers.croussards.model.Review;
import fr.univ_poitiers.croussards.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/reviews")
    public ResponseEntity<Review> addReview(@Valid @RequestBody Review review) {
        reviewService.saveReview(review);
        return reviewService.responseReview(review);
    }

    @GetMapping("/reviews/{id}")
    public ResponseEntity<Review> getReview(@PathVariable Long id) {
        Review s = reviewService.getReview(id);
        return reviewService.responseReview(s);
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getReviews() {
        return reviewService.responseReviews(reviewService.getReviews());
    }

    @PutMapping("/reviews/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, @Valid @RequestBody Review Review) {
        Review updateReview = reviewService.getReview(id);
        reviewService.updateReview(updateReview, Review);
        reviewService.saveReview(updateReview);
        return ResponseEntity.ok(updateReview);
    }

    @DeleteMapping("/reviews/{id}")
    public ResponseEntity<Review> deleteReview(@PathVariable Long id){
        Review Review = reviewService.getReview(id);
        reviewService.deleteReview(id);
        return reviewService.responseReview(Review);
    }
}
