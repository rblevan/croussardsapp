package fr.univpoitiers.croussardsapi.controller;

import fr.univpoitiers.croussardsapi.model.Review;
import fr.univpoitiers.croussardsapi.model.Student;
import fr.univpoitiers.croussardsapi.service.StudentService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students/{id}")
    public ResponseEntity<?> getStudent(@PathVariable Long id) {
        Student s = studentService.getStudent(id);
        return studentService.myResponse(s);
    }

    @GetMapping("/students")
    public ResponseEntity<?> getStudents() {
        return studentService.myResponse(studentService.getStudents());
    }

    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student) {
        Student savedStudent = studentService.saveStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @Valid @RequestBody Student student) {
        Student updateStudent = studentService.getStudent(id);
        studentService.updateStudent(updateStudent, student);
        studentService.saveStudent(updateStudent);
        return studentService.myResponse(updateStudent);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/students/{id}/reviews")
    public ResponseEntity<?> getReviewsByStudent(@PathVariable Long id) {
        Iterable<Review> reviews = studentService.getReviews(id);
        return studentService.myResponse(reviews);
    }
}