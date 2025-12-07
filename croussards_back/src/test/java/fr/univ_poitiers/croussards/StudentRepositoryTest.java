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
        // nouvel étudiant à sauvegarder
        Student student = new Student();
        student.setUsername("jdoe");
        student.setName("Doe");
        student.setFirstName("John");
        student.setEmail("john.doe@example.com");
        student.setPassword("hashed_password"); // mot de passe haché
        student.setBirthDate(LocalDate.of(2000, 1, 15));
        entityManager.persistAndFlush(student);

        // retrouver l'étudiant par son ID
        Optional<Student> foundStudent = studentRepository.findById(student.getId());

        // l'etudiant est trouvé et ses données sont correctes
        assertThat(foundStudent).isPresent();
        assertThat(foundStudent.get().getUsername()).isEqualTo("jdoe");
        assertThat(foundStudent.get().getEmail()).isEqualTo(student.getEmail());
    }
}