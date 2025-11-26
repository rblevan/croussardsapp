package fr.univ_poitiers.croussards.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "students")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num_student;

    private String last_name;

    private String first_name;

    private String mail;

    private String pwd_hash;

    private Date date_birth;

    private String pseudo;

    @OneToMany(mappedBy = "student")
    @JsonIgnoreProperties("student")
    private List<Review> reviews = new ArrayList<>();

}