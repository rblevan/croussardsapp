package fr.univ_poitiers.croussards.service;

// import from our package

import fr.univ_poitiers.croussards.dto.RegisterRequest;
import fr.univ_poitiers.croussards.model.Student;
import fr.univ_poitiers.croussards.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    public Student register(RegisterRequest request) {
        Student newStudent = new Student();
        newStudent.setName(request.getName());
        newStudent.setFirstName(request.getFirstName());
        newStudent.setMail(request.getMail());
        newStudent.setPwdHash(passwordEncoder.encode(request.getPassword()));

        return studentRepository.save(newStudent);
    }

    public java.util.List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
