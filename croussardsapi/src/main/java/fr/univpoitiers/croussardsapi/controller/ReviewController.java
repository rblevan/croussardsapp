package fr.univpoitiers.croussardsapi.controller;

import fr.univpoitiers.croussardsapi.model.Review;
import fr.univpoitiers.croussardsapi.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews/{id}")
    public ResponseEntity<?> getReview(@PathVariable Long id) {
        Review s = reviewService.getReview(id);
        return reviewService.myResponse(s);
    }

    @GetMapping("/reviews")
    public ResponseEntity<?> getReviews() {
        Iterable<Review> reviews = reviewService.getReviews();
        return reviewService.myResponse(reviews);
    }

    @PostMapping("/reviews")
    public ResponseEntity<?> addReview(@Valid @RequestBody Review review) {
        reviewService.saveReview(review);
        return reviewService.myResponse(review);
    }

    @PutMapping("/reviews/{id}")
    public ResponseEntity<?> updateReview(@PathVariable Long id, @Valid @RequestBody Review Review) {
        Review updateReview = reviewService.getReview(id);
        reviewService.updateReview(updateReview, Review);
        reviewService.saveReview(updateReview);
        return reviewService.myResponse(updateReview);
    }

    @DeleteMapping("/reviews/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable Long id){
        Review review = reviewService.getReview(id);
        reviewService.deleteReview(id);
        return reviewService.myResponse(review);
    }
}
