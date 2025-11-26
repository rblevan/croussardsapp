package fr.univpoitiers.croussardsapi.service;

import fr.univpoitiers.croussardsapi.model.Review;
import fr.univpoitiers.croussardsapi.repository.ReviewRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Data
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public Review getReview(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Review not found"));
    }

    public Iterable<Review> getReviews() {
        return reviewRepository.findAll();
    }

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    public void deleteReview(Long id){
        reviewRepository.deleteById(id);
    }

    public void updateReview (Review review, Review updateReview){
        review.setId_review(updateReview.getId_review());
        review.setComments(updateReview.getComments());
        review.setStudent(updateReview.getStudent());
        review.setRestaurant(updateReview.getRestaurant());
        review.setNb_stars(updateReview.getNb_stars());
        review.setDate_publi(updateReview.getDate_publi());
    }


    public ResponseEntity<Review> responseReview(Review review){
        if (review == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(review);
    }

    public ResponseEntity<Iterable<Review>> responseReviews(Iterable<Review> reviews){
        if (reviews == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reviews);
    }
}
