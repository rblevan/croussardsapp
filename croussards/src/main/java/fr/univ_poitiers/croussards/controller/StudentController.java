package fr.univ_poitiers.croussards.controller;

import fr.univ_poitiers.croussards.dto.LoginRequest;
import fr.univ_poitiers.croussards.dto.RegisterRequest;
import fr.univ_poitiers.croussards.model.Student;
import fr.univ_poitiers.croussards.repository.StudentRepository;
import fr.univ_poitiers.croussards.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class StudentController {
    private StudentRepository studentRepository;
    private StudentService studentService;
    /*
    @GetMapping("/{id}")

    public Student getUser(@PathVariable Integer id) {
    Student student = studentRepository.findById(id).orElseThrow(NoSuchElementException::new);
    return student;
    } */

    @GetMapping("/")
    public ResponseEntity<String> getStudents() {
        return ResponseEntity.ok("Hello World");
    }

    // POUR LE DTO (EVAN)

    @PostMapping("/register")
    public ResponseEntity<Student> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(studentService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<Student> login(@RequestBody LoginRequest request) {
        try {
            Student student = studentService.login(request);
            return ResponseEntity.ok(student);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}