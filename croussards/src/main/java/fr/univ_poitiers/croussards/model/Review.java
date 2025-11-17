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

    // Corrigé : La colonne s'appelle 'student_id' (ou ce que vous voulez),
    // mais elle ne doit plus être 'user_id'
    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    @JsonIgnore
    private Student student;

    // Ajouté : Relation vers le Restaurant (suppose que Restaurant est une entité)
    @ManyToOne(optional = false)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    // Ajouté : Relation vers les Photos (suppose que Photo est une entité)
    // 'mappedBy = "review"' signifie que la classe Photo a un champ 'private Review review;'
    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Photos> photos = new ArrayList<>();

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