package fr.univ_poitiers.croussards;

import fr.univ_poitiers.croussards.model.Review;
import fr.univ_poitiers.croussards.model.Student;
import fr.univ_poitiers.croussards.repository.ReviewRepository;
import fr.univ_poitiers.croussards.repository.StudentRepository;
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

   /* @Bean
    CommandLineRunner runner(StudentRepository studentRepository, ReviewRepository reviewRepository) {
        return args -> {

            Student user1 = new Student(33, "stephane@email.com", "toto1234");
            //Review review = new Review(user1, "J'adore cette personne", 4.5f);
            //user1.getReviews().add(review);

            studentRepository.save(user1);
            //reviewRepository.save(review);

            Student user2 = new Student(22, "evan@email.com", "fhueij18560");
            studentRepository.save(user2);

            Student saved = studentRepository.findById(user1.getIdEtu()).orElseThrow(NoSuchElementException::new);
        };
    }
*/
}
