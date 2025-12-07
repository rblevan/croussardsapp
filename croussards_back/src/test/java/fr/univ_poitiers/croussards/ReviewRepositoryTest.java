package fr.univ_poitiers.croussards;

import fr.univ_poitiers.croussards.model.Restaurant;
import fr.univ_poitiers.croussards.model.Review;
import fr.univ_poitiers.croussards.model.Student;
import fr.univpoitiers.croussardsback.repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ReviewRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    void whenSaved_thenCanBeFoundByIdWithRelationships() {
        // Given: a persisted student and restaurant
        Student student = new Student();
        student.setUsername("testuser");
        student.setName("Doe");
        student.setFirst_name("John");
        entityManager.persist(student);

        Restaurant restaurant = new Restaurant();
        restaurant.setName("Le Crous'tille");
        entityManager.persist(restaurant);

        // And a new review linking them
        Review review = new Review();
        review.setStudent(student);
        review.setRestaurant(restaurant);
        review.setRating(4);
        review.setComment("Pretty good!");
        review.setPublicationDate(LocalDateTime.now());
        entityManager.persistAndFlush(review);

        // When: we try to find the review by its ID
        Optional<Review> foundReview = reviewRepository.findById(review.getId());

        // Then: the review is found and its data and relationships are correct
        assertThat(foundReview).isPresent();
        assertThat(foundReview.get().getComment()).isEqualTo("Pretty good!");
        assertThat(foundReview.get().getStudent().getId()).isEqualTo(student.getNum_student());
        assertThat(foundReview.get().getRestaurant().getId_resto()).isEqualTo(restaurant.getId_resto());
    }
}