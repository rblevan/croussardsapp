package fr.univpoitiers.croussardsweb.model;

import lombok.Data;

import java.util.Date;

@Data
public class Review {

    private Long id_review;

    private Long num_student;

    private Long id_resto;

    private int nb_stars;

    private String comments;

    private Date date_publi;

}
