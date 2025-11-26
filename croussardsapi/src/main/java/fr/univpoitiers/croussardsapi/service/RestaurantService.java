package fr.univpoitiers.croussardsapi.service;

import fr.univpoitiers.croussardsapi.model.Restaurant;
import fr.univpoitiers.croussardsapi.model.Review;
import fr.univpoitiers.croussardsapi.repository.RestaurantRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Data
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public Restaurant getRestaurant(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant not found"));
    }

    public Iterable<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public void deleteRestaurant(Long id){
        restaurantRepository.deleteById(id);
    }

    public ResponseEntity<Restaurant> responseRestaurant(Restaurant restaurant){
        if (restaurant == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(restaurant);
    }

    public ResponseEntity<Iterable<Restaurant>> responseRestaurants(Iterable<Restaurant> restaurants){
        if (restaurants == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(restaurants);
    }

    public ResponseEntity<Iterable<Review>> responseReviews(Iterable<Review> reviews){
        if (reviews == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reviews);
    }

    public void updateRestaurant(Restaurant restaurant, Restaurant updateRestaurant){
        restaurant.setName(updateRestaurant.getName());
        restaurant.setAddress(updateRestaurant.getAddress());
        restaurant.setReviews(updateRestaurant.getReviews());
        restaurant.setId_resto(updateRestaurant.getId_resto());
        restaurant.setType_resto(updateRestaurant.getType_resto());
    }

    public Iterable<Review> getReviewsByRestaurant(Long idRestaurant){
        Restaurant restaurant = getRestaurant(idRestaurant);

        return restaurant.getReviews();
    }
}
