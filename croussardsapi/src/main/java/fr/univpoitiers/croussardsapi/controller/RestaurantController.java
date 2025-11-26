package fr.univpoitiers.croussardsapi.controller;

import fr.univpoitiers.croussardsapi.model.Restaurant;
import fr.univpoitiers.croussardsapi.model.Review;
import fr.univpoitiers.croussardsapi.service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
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
    public ResponseEntity<Iterable<Restaurant>> getRestaurants() {
        return restaurantService.responseRestaurants(restaurantService.getRestaurants());
    }

    @GetMapping("/restaurants/{id}/reviews")
    public ResponseEntity<Iterable<Review>> getReviewsByRestaurant(@PathVariable Long id) {
        return restaurantService.responseReviews(restaurantService.getReviewsByRestaurant(id));
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
