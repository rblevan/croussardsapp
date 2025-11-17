package fr.univ_poitiers.croussards.repository;

import fr.univ_poitiers.croussards.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // JpaRepository fournit déjà findById(), findAll(), save(), delete(), etc.
}