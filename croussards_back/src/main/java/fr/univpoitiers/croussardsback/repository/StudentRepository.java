package fr.univpoitiers.croussardsback.repository;

import fr.univ_poitiers.croussards.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // You could add methods like findByUsername(String username) here
}