package fr.univpoitiers.croussardsweb.model;

import lombok.Data;

import java.util.Date;

@Data
public class Student {
    private Long num_student;

    private String last_name;

    private String first_name;

    private String mail;

    private String pwd_hash;

    private Date date_birth;

    private String pseudo;

}
