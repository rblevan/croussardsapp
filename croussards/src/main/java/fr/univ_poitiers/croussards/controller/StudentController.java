package fr.univ_poitiers.croussards.controller;

import fr.univ_poitiers.croussards.model.Student;
import fr.univ_poitiers.croussards.repository.StudentRepository;
import fr.univ_poitiers.croussards.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        return studentService.
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable Long id) {
        Optional<Student> student = StudentService.getStudent(id);
        return student.orElse(null);
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
}
