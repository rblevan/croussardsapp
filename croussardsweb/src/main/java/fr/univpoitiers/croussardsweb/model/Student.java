package fr.univpoitiers.croussardsweb.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Student {
    private Long num_student;

    private String last_name;

    private String first_name;

    private String mail;

    private String pwd_hash;

    private Date date_birth;

    private String pseudo;

    private Iterable<Review> reviews;

}
