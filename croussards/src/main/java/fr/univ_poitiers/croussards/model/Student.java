package fr.univ_poitiers.croussards.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

// Supposant que la classe Review existe aussi dans ce package ou est importée
// import fr.univ_poitiers.croussards.model.Review;
@Data
@Entity
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Student {
    @OneToMany(mappedBy = "student")
    private List<Review> reviews = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "num_students")
    private Long numStudents;

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