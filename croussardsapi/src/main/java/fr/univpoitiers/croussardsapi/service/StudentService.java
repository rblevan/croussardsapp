package fr.univpoitiers.croussardsapi.service;

import fr.univpoitiers.croussardsapi.model.Review;
import fr.univpoitiers.croussardsapi.model.Student;
import fr.univpoitiers.croussardsapi.repository.ReviewRepository;
import fr.univpoitiers.croussardsapi.repository.StudentRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Data
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student getStudent(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
    }

    public Iterable<Student> getStudents() {
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
        student.setLast_name(updateStudent.getLast_name().toUpperCase());
        student.setFirst_name(updateStudent.getFirst_name().toUpperCase());
        student.setPseudo(updateStudent.getPseudo().toLowerCase());
        student.setPwd_hash(updateStudent.getPwd_hash());
        student.setMail(updateStudent.getMail());
        student.setDate_birth(updateStudent.getDate_birth());
        student.setReviews(updateStudent.getReviews());
    }


    public ResponseEntity<?> myResponse(Object body) {
        if (body != null) {
            return ResponseEntity.ok(body);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public Iterable<Review> getReviews(Long idStudent){
        Student student = getStudent(idStudent);
        return student.getReviews();
    }
}
