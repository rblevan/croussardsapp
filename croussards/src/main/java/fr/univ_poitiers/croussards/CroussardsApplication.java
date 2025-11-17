package fr.univ_poitiers.croussards;

import fr.univ_poitiers.croussards.model.Review;
import fr.univ_poitiers.croussards.model.User;
import fr.univ_poitiers.croussards.repository.ReviewRepository;
import fr.univ_poitiers.croussards.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.NoSuchElementException;

@EnableJpaRepositories
@SpringBootApplication
public class CroussardsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CroussardsApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(UserRepository userRepository, ReviewRepository reviewRepository) {
        return args -> {

            User user1 = new User("stephane@email.com", "toto1234");
            Review review = new Review(user1, "J'adore cette personne", 4.5f);
            user1.getReviews().add(review);

            userRepository.save(user1);
            reviewRepository.save(review);

            User user2 = new User("evan@email.com", "fhueij18560");
            userRepository.save(user2);

            User saved = userRepository.findById(user1.getId()).orElseThrow(NoSuchElementException::new);
        };
    }

}
