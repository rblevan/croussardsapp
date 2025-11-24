package fr.univ_poitiers.croussards.service;

import fr.univ_poitiers.croussards.model.Review;
import fr.univ_poitiers.croussards.repository.ReviewRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public Optional<Review> getReview(Long id) {
        return reviewRepository.findById(id);
    }

    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }

    public Review saveStudent(Review review) {
        return reviewRepository.save(review);
    }

}
