package fr.univpoitiers.croussardsweb.model;


import lombok.Data;

import java.util.List;

@Data
public class Restaurant {

    private Long id_resto;

    private String name;

    private String address;

    private String type_resto;

    private Iterable<Review> reviews;


}