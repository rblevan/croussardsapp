package fr.univ_poitiers.croussards.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    @JsonIgnore
    private Student student;

    @ManyToOne(optional = false)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    // Conservé de votre 2ème fichier (remplace 'int note')
    private float ranking;

    // Conservé de votre 2ème fichier
    private String comment;

    // Constructeur mis à jour
    public Review(Student student, Restaurant restaurant, String comment, float ranking) {
        this.student = student;
        this.restaurant = restaurant;
        this.comment = comment;
        this.ranking = ranking;
    }
}