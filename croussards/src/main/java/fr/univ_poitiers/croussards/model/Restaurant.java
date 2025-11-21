package fr.univ_poitiers.croussards.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;



@Entity
@Table(name = "restaurants")
@Data
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_resto;

    private String name;

    private String address;

    private String type_resto;

    @OneToMany(mappedBy = "restaurant")
    @JsonIgnore
    private List<Review> reviews;

}