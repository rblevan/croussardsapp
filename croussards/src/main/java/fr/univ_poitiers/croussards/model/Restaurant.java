package fr.univ_poitiers.croussards.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idResto")
    private Long idResto;

    @Column(name = "name")
    private String name;

    @Column(name = "adress")
    private String adress;

    @Column(name = "typeResto")
    private String typeResto;

    @OneToMany(mappedBy = "restaurant")
    private List<Review> reviews;

}