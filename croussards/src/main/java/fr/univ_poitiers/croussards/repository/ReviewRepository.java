package fr.univ_poitiers.croussards.repository;

import fr.univ_poitiers.croussards.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
