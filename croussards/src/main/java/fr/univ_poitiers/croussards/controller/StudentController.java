package fr.univ_poitiers.croussards.controller;

import fr.univ_poitiers.croussards.model.Student;
import fr.univ_poitiers.croussards.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("students")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class StudentController {
   /* private StudentRepository studentRepository;

    @GetMapping("/{id}")

    public Student getUser(@PathVariable Integer id) {
        Student student = studentRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return student;
    } */

    @GetMapping("/")
    public ResponseEntity<String> getStudents() {
        return ResponseEntity.ok("Hello World");
    }
}