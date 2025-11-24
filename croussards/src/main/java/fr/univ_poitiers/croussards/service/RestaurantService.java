package fr.univ_poitiers.croussards.service;

import fr.univ_poitiers.croussards.model.Restaurant;
import fr.univ_poitiers.croussards.repository.RestaurantRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Data
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public Restaurant getRestaurant(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant not found"));
    }

    public List<Restaurant> getRestaurants() {
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

    public ResponseEntity<List<Restaurant>> responseRestaurants(List<Restaurant> restaurants){
        if (restaurants == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(restaurants);
    }

    public void updateRestaurant(Restaurant restaurant, Restaurant updateRestaurant){
        restaurant.setName(updateRestaurant.getName());
        restaurant.setAddress(updateRestaurant.getAddress());
        restaurant.setReviews(updateRestaurant.getReviews());
        restaurant.setId_resto(updateRestaurant.getId_resto());
        restaurant.setType_resto(updateRestaurant.getType_resto());
    }
}
