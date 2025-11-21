package fr.univ_poitiers.croussards.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resto")
    private Long idResto;

    private String name;

    private String adress;

    @Column(name = "type_resto")
    private String typeResto;

    @OneToMany(mappedBy = "restaurant")
    private List<Review> reviews;

}