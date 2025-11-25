package fr.univpoitiers.croussardsweb.controller;

import fr.univpoitiers.croussardsweb.model.Student;
import fr.univpoitiers.croussardsweb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/students")
    public String studentsPage(Model model) {
        Iterable<Student> students = studentService.getStudents();

        if (students == null) {
            students = new ArrayList<>();
        }

        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/students/{id}")
    public String getStudent(Model model, @PathVariable Long id) {
        Student student = studentService.getStudent(id);

        if (student == null) {
            return "/students";
        }

        model.addAttribute("student", student);
        return "student";
    }
}
