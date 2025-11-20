package fr.univ_poitiers.croussards.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_picture")
    private Long idPicture;

    @OneToOne
    @JoinColumn(name = "idReviews")
    private Review review;

    private String path;
}
