package fr.univ_poitiers.croussards.controller;

import fr.univ_poitiers.croussards.model.Restaurant;
import fr.univ_poitiers.croussards.service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/restaurants")
    public ResponseEntity<Restaurant> addRestaurant(@Valid @RequestBody Restaurant restaurant) {
        restaurantService.saveRestaurant(restaurant);
        return restaurantService.responseRestaurant(restaurant);
    }

    @GetMapping("/restaurants/{id}")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable Long id) {
        Restaurant r = restaurantService.getRestaurant(id);
        return restaurantService.responseRestaurant(r);
    }

    @GetMapping("/restaurants")
    public ResponseEntity<List<Restaurant>> getRestaurants() {
        return restaurantService.responseRestaurants(restaurantService.getRestaurants());
    }

    @PutMapping("/restaurants/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id, @Valid @RequestBody Restaurant restaurant) {
        Restaurant updateRestaurant = restaurantService.getRestaurant(id);
        restaurantService.updateRestaurant(updateRestaurant, restaurant);
        restaurantService.saveRestaurant(updateRestaurant);
        return ResponseEntity.ok(updateRestaurant);
    }

    @DeleteMapping("/restaurants/{id}")
    public ResponseEntity<Restaurant> deleteRestaurant(@PathVariable Long id){
        Restaurant restaurant = restaurantService.getRestaurant(id);
        restaurantService.deleteRestaurant(id);
        return restaurantService.responseRestaurant(restaurant);
    }


}
