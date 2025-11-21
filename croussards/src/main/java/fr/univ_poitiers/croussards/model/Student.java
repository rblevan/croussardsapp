package fr.univ_poitiers.croussards.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "students")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num_student;

    private String name;

    private String first_name;

    private String mail;

    private String pwd_hash;

    private String date_birth; // Ideally LocalDate

    private String pseudo;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<Review> reviews = new ArrayList<>();

}