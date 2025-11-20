package fr.univ_poitiers.croussards.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

// Supposant que la classe Review existe aussi dans ce package ou est importée
// import fr.univ_poitiers.croussards.model.Review;

@Entity
@Table(name = "Students")
public class Student {
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "num_etu")
    private Long numEtu;

    private String name;

    @Column(name = "first_name")
    private String firstname;

    private String mail;

    @Column(name = "pwd_hash")
    private String pwdHash;

    @Column(name = "date_birth")
    private String dateBirth;

    private String pseudo;

}