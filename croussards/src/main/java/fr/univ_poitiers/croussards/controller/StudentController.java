package fr.univ_poitiers.croussards.controller;

import fr.univ_poitiers.croussards.model.Restaurant;
import fr.univ_poitiers.croussards.model.Review;
import fr.univ_poitiers.croussards.model.Student;
<<<<<<< HEAD
import fr.univ_poitiers.croussards.repository.RestaurantRepository;
import fr.univ_poitiers.croussards.repository.ReviewRepository;
import fr.univ_poitiers.croussards.repository.StudentRepository;
import jakarta.annotation.PostConstruct;
=======
import fr.univ_poitiers.croussards.service.StudentService;
>>>>>>> f3bc149 (les mappings marchent maintenant)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class StudentController {

    @Autowired
    private final StudentRepository studentRepository;
    @Autowired
    private final ReviewRepository reviewRepository;
    @Autowired
    private final RestaurantRepository restaurantRepository;

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
<<<<<<< HEAD
        return studentRepository.save(student);
    }

    @PostMapping("/restaurants")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
=======
        return studentService.saveStudent(student);
    }

    @GetMapping("/students/{id}")
    public Optional<Student> getStudent(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudent(id);
        return student;
>>>>>>> f3bc149 (les mappings marchent maintenant)
    }

    @PostMapping("/reviews")
    public Review addReview(@RequestBody Review review) {
        return reviewRepository.save(review);
    }


    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }
<<<<<<< HEAD

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant getRestaurant(@PathVariable Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    @GetMapping("/reviews")
    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }

    @GetMapping("/reviews/{id}")
    public Review getReview(@PathVariable Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }
}
=======
}
>>>>>>> f3bc149 (les mappings marchent maintenant)
