package fr.univ_poitiers.croussards.controller;

import fr.univ_poitiers.croussards.model.Student;
import fr.univ_poitiers.croussards.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student) {
        studentService.saveStudent(student);
        return studentService.responseStudent(student);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student s = studentService.getStudent(id);
        return studentService.responseStudent(s);
    }

    @GetMapping("/students")
    public ResponseEntity<Iterable<Student>> getStudents() {
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
}