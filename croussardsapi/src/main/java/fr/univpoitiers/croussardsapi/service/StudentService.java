package fr.univ_poitiers.croussards.service;

// import from our package

import fr.univ_poitiers.croussards.dto.RegisterRequest;
import fr.univ_poitiers.croussards.model.Student;
import fr.univ_poitiers.croussards.repository.StudentRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Data
@Service
@RequiredArgsConstructor
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    public Student getStudent(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

    public void updateStudent (Student student, Student updateStudent){
        student.setNum_student(updateStudent.getNum_student());
        student.setName(updateStudent.getName());
        student.setFirst_name(updateStudent.getFirst_name());
        student.setUsername(updateStudent.getUsername());
        student.setPwd_hash(updateStudent.getPwd_hash());
        student.setMail(updateStudent.getMail());
        student.setDate_birth(updateStudent.getDate_birth());
        student.setReviews(updateStudent.getReviews());
    }

    public ResponseEntity<Student> responseStudent(Student student){
        if (student == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    public ResponseEntity<List<Student>> responseStudents(List<Student> students){
        if (students == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(students);
    }

    // DTO

    public Student register(RegisterRequest request) {
        Student newStudent = new Student();
        newStudent.setName(request.getName());
        newStudent.setFirst_name(request.getFirstName());
        newStudent.setMail(request.getMail());
        newStudent.setPwd_hash(passwordEncoder.encode(request.getPassword()));

        return studentRepository.save(newStudent);
    }

    public java.util.List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
