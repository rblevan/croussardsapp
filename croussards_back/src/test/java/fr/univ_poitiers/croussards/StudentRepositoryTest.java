package fr.univ_poitiers.croussards;

import fr.univ_poitiers.croussards.model.Student;
import fr.univpoitiers.croussardsback.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void whenSaved_thenCanBeFoundById() {
        // Given: a new student
        Student student = new Student();
        student.setUsername("jdoe");
        student.setName("Doe");
        student.setFirstName("John");
        student.setEmail("john.doe@example.com");
        student.setPassword("hashed_password"); // In a real app, this would be encoded
        student.setBirthDate(LocalDate.of(2000, 1, 15));
        entityManager.persistAndFlush(student);

        // When: we try to find the student by its ID
        Optional<Student> foundStudent = studentRepository.findById(student.getId());

        // Then: the student is found and its data is correct
        assertThat(foundStudent).isPresent();
        assertThat(foundStudent.get().getUsername()).isEqualTo("jdoe");
        assertThat(foundStudent.get().getEmail()).isEqualTo(student.getEmail());
    }
}