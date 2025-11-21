package fr.univ_poitiers.croussards.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


import fr.univ_poitiers.croussards.model.Review;

@Entity
@Table(name = "Students")
public class Student {
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    /**
     * student number
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEtu;

    private String name;
    private String surname;
    private String email;
    private String passwordHash;
    private String username;

    public int getIdEtu() {
        return this.idEtu;
    }

    /**
     *
     * @param idEtu
     */
    public void setIdEtu(int idEtu) {
        this.idEtu = idEtu;
    }

    public String getName() {
        return this.name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        // TODO - implement Student.setName
        throw new UnsupportedOperationException();
    }

    public String getSurname() {
        return this.surname;
    }

    /**
     *
     * @param surname
     */
    public void setSurname(String surname) {
        // TODO - implement Student.setSurname
        throw new UnsupportedOperationException();
    }

    public String getEmail() {
        return this.email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        // TODO - implement Student.setEmail
        throw new UnsupportedOperationException();
    }

    public String getPasswordHash() {
        return this.passwordHash;
    }

    /**
     *
     * @param passwordHash
     */
    public void setPasswordHash(String passwordHash) {
        // TODO - implement Student.setPasswordHash
        throw new UnsupportedOperationException();
    }

    public String getUsername() {
        return this.username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        // TODO - implement Student.setUsername
        throw new UnsupportedOperationException();
    }

    public Student() {
        // TODO - implement Student.Student
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param idEtu
     * @param name
     * @param surname
     */
    public Student(int idEtu, String name, String surname) {
        // TODO - implement Student.Student
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param password
     */
    public void hashPassword(String password) {
        // TODO - implement Student.hashPassword
        throw new UnsupportedOperationException();
    }

}