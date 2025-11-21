package fr.univ_poitiers.croussards.service;

import fr.univ_poitiers.croussards.model.Review;
import fr.univ_poitiers.croussards.repository.ReviewRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
public class ReviewService {
    @Autowired
    private static ReviewRepository reviewRepository;

    public static Optional<Review> getReview(final Long id) {
        return reviewRepository.findById(id);
    }

    public Iterable<Review> getReviews() {
        return reviewRepository.findAll();
    }

}
