package fr.univ_poitiers.croussards.repository;

import fr.univ_poitiers.croussards.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Long> {
}
