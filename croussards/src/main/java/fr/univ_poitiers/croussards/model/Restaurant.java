package fr.univ_poitiers.croussards.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
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