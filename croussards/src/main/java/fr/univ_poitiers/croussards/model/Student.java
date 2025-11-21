package fr.univ_poitiers.croussards.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

// Supposant que la classe Review existe aussi dans ce package ou est importée
// import fr.univ_poitiers.croussards.model.Review;

@Data
@Entity
public class Student {
    @OneToMany(mappedBy = "student")
    private List<Review> reviews = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "num_student")
    private Long numStudent;

    private String name;

    @Column(name = "first_name")
    private String firstName;

    private String mail;

    @Column(name = "pwd_hash")
    private String pwdHash;

    @Column(name = "date_birth")
    private String dateBirth;

    private String pseudo;

}