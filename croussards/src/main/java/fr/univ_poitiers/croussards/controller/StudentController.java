package fr.univ_poitiers.croussards.controller;

import fr.univ_poitiers.croussards.model.Restaurant;
import fr.univ_poitiers.croussards.model.Review;
import fr.univ_poitiers.croussards.model.Student;
import fr.univ_poitiers.croussards.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;


    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping("/students/{id}")
    public Optional<Student> getStudent(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudent(id);
        return student;
    }

    @PostMapping("/reviews")
    public Review addReview(@RequestBody Review review) {
        return reviewRepository.save(review);
    }


    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }
}
