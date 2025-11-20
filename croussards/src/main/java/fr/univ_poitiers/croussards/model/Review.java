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
@Table(name = "Reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reviews")
    private Long idReviews;

    // Relation ManyToOne vers Etudiant
    @ManyToOne
    @JoinColumn(name = "student")
    private Student student;

    // Relation ManyToOne vers Restaurant
    @ManyToOne
    @JoinColumn(name = "resto")
    private Restaurant restaurant;

    @Column(name = "nb_stars")
    private int nbStars;

    private String comments;

    @Column(name = "date_publi")
    private Date datePubli;

}
