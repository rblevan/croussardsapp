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
<<<<<<< HEAD
>>>>>>> f3bc149 (les mappings marchent maintenant)
=======
import jakarta.validation.Valid;
>>>>>>> a0cb8d6 (amelioration de mes methodes put get post delete update)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
<<<<<<< HEAD
import java.util.NoSuchElementException;
=======
>>>>>>> a0cb8d6 (amelioration de mes methodes put get post delete update)

@RestController
public class StudentController {

    @Autowired
    private final StudentRepository studentRepository;
    @Autowired
    private final ReviewRepository reviewRepository;
    @Autowired
    private final RestaurantRepository restaurantRepository;

    @PostMapping("/students")
<<<<<<< HEAD
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
=======
    public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student) {
        studentService.saveStudent(student);
        return studentService.responseStudent(student);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student s = studentService.getStudent(id);
        return studentService.responseStudent(s);
>>>>>>> a0cb8d6 (amelioration de mes methodes put get post delete update)
    }

    @PostMapping("/reviews")
    public Review addReview(@RequestBody Review review) {
        return reviewRepository.save(review);
    }


    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        return studentService.responseStudents(studentService.getStudents());
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @Valid @RequestBody Student student) {
        Student updateStudent = studentService.getStudent(id);
        studentService.updateStudent(updateStudent, student);
        studentService.saveStudent(updateStudent);
        return ResponseEntity.ok(updateStudent);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id){
        Student student = studentService.getStudent(id);
        studentService.deleteStudent(id);
        return studentService.responseStudent(student);
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
