package fr.univ_poitiers.croussards.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
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
    @JsonIgnoreProperties("restaurant")
    private List<Review> reviews = new ArrayList<>();

}