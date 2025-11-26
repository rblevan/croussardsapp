package fr.univpoitiers.croussardsapi.controller;

import fr.univpoitiers.croussardsapi.model.Review;
import fr.univpoitiers.croussardsapi.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
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
    public ResponseEntity<Iterable<Review>> getReviews() {
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
