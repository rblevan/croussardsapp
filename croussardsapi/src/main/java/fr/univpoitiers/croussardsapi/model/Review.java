package fr.univpoitiers.croussardsapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties({"reviews"})
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_resto")
    @JsonIgnoreProperties({"reviews"})
    private Restaurant restaurant;

    private int nb_stars;

    private String comments;

    private Date date_publi;



}
