package fr.univ_poitiers.croussards.controller;

import fr.univ_poitiers.croussards.model.Student;
import fr.univ_poitiers.croussards.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("students")
@RequiredArgsConstructor
public class UserController {
    private StudentRepository studentRepository;

    @GetMapping("/{id}")

    public Student getUser(@PathVariable Integer id) {
        Student student = studentRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return student;
    }
}