package fr.univ_poitiers.croussards.repository;

import fr.univ_poitiers.croussards.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
