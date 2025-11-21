package fr.univ_poitiers.croussards.repository;

import fr.univ_poitiers.croussards.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
}
