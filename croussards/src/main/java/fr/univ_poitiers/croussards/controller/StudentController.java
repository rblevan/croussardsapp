package fr.univ_poitiers.croussards.controller;

import fr.univ_poitiers.croussards.dto.RegisterRequest;
import fr.univ_poitiers.croussards.model.Student;
import fr.univ_poitiers.croussards.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/")
    public ResponseEntity<String> getStudents() {
        return ResponseEntity.ok("Hello World");
    }

    // POUR LE DTO (EVAN)

    @PostMapping("/register")
    public ResponseEntity<Student> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(studentService.register(request));
    }
}
