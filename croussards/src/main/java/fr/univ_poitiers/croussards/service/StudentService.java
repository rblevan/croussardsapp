package fr.univ_poitiers.croussards.service;

import fr.univ_poitiers.croussards.dto.LoginRequest;
import fr.univ_poitiers.croussards.dto.RegisterRequest;
import fr.univ_poitiers.croussards.model.Student;
import fr.univ_poitiers.croussards.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private StudentRepository studentRepository;

    public Student register(RegisterRequest request) {
        Student newStudent = new Student();
        newStudent.setName(request.getName());
        newStudent.setFirstName(request.getFirstName());
        newStudent.setMail(request.getMail());
        newStudent.setPwdHash(request.getPassword());

        return studentRepository.save(newStudent);
    }

    public Student login(LoginRequest request) {
        Optional<Student> studentBox = studentRepository.findById(request.getNumStudent());

        if (studentBox.isPresent()) {
            Student student = studentBox.get();

            if (student.getPwdHash().equals(request.getPassword())) {
                return student;
            }
        }

        throw new RuntimeException("Numéro étudiant ou mot de passe incorrect");
    }

    public java.util.List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


}