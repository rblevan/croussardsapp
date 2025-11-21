package fr.univ_poitiers.croussards.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_review")
    private Long idReview;

    // Relation ManyToOne vers Etudiant
    @ManyToOne
    @JoinColumn(name = "student")
    private Student student;

    // Relation ManyToOne vers Restaurant
    @ManyToOne
    @JoinColumn(name = "restaurant")
    private Restaurant restaurant;

    @Column(name = "nb_stars")
    private int nbStars;

    private String comments;

    @Column(name = "date_publi")
    private Date datePubli;

}
