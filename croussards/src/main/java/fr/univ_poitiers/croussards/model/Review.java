package fr.univ_poitiers.croussards.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private Student student;
    private float ranking;
    private String comment;

    public Review(Student student, String comment, float ranking) {
        this.student = student;
        this.ranking = ranking;
        this.comment = comment;
    }
}
