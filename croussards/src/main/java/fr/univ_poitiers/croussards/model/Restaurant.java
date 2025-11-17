package fr.univ_poitiers.croussards.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "resto_id", nullable = false)
    @JsonIgnore
    private Restaurant resto;
    private String nom;
    private String adress;
    public String type;

    public Restaurant(Restaurant resto, String nom, String adress, String type) {
        this.resto = resto;
        this.nom = nom;
        this.adress = adress;
        this.type = type;
    }
}
