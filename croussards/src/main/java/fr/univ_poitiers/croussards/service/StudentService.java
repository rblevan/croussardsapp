package fr.univ_poitiers.croussards.service;

import fr.univ_poitiers.croussards.model.Restaurant;
import fr.univ_poitiers.croussards.model.Review;
import fr.univ_poitiers.croussards.model.Student;
import fr.univ_poitiers.croussards.repository.RestaurantRepository;
import fr.univ_poitiers.croussards.repository.ReviewRepository;
import fr.univ_poitiers.croussards.repository.StudentRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class StudentService {
    @Autowired
    private static StudentRepository studentRepository;


    public static Optional<Student> getStudent(final Long id) {
        return studentRepository.findById(id);
    }


    public Iterable<Student> getStudents() {
        return studentRepository.findAll();
    }

}