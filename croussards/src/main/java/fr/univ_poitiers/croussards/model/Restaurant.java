package fr.univ_poitiers.croussards.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(
            mappedBy = "restaurant",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Review> reviews = new ArrayList<>();

    @Column(nullable = false)
    private String nom;

    @Column(name = "address")
    private String adress;

    @Column(name = "restaurant_type")
    public String type;

    public Restaurant(String nom, String adress, String type) {
        this.nom = nom;
        this.adress = adress;
        this.type = type;
    }


    public void addReview(Review review) {
        reviews.add(review);
        review.setRestaurant(this);
    }

    public void removeReview(Review review) {
        reviews.remove(review);
        review.setRestaurant(null);
    }
}