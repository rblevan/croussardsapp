package fr.univ_poitiers.croussards.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "reviews")
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_review;

    @ManyToOne
    @JoinColumn(name = "num_student")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_resto")
    private Restaurant restaurant;

    private int nb_stars;

    private String comments;

    private Date date_publi;



}
