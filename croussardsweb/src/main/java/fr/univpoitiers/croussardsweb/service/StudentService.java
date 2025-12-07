package fr.univpoitiers.croussardsweb.service;

import fr.univpoitiers.croussardsweb.model.Student;
import fr.univpoitiers.croussardsweb.repository.StudentProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentProxy studentProxy;

    public Student getStudent(Long id) {
        return studentProxy.getStudent(id);
    }

    public Iterable<Student> getStudents() {
        return studentProxy.getStudents();
    }

    public void deleteStudent(final int id) {
        studentProxy.deleteStudent(id);
    }

    public Student saveStudent(Student student) {
        Student savedStudent;

        student.setLastName(student.getLastName().toUpperCase());
        student.setFirstName(student.getFirstName().toUpperCase());

        if (student.getNumStudent() == null) {
            savedStudent = studentProxy.createStudent(student);
        } else {
            savedStudent = studentProxy.updateStudent(student);
        }

        return savedStudent;
    }

    public ResponseEntity<Student> responseStudent(Student student) {
        if (student == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    public ResponseEntity<Iterable<Student>> responseStudents(Iterable<Student> students){
        if (students == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(students);
    }
}



