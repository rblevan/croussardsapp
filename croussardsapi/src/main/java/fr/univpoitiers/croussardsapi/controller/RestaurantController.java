package fr.univpoitiers.croussardsapi.controller;

import fr.univpoitiers.croussardsapi.model.Restaurant;
import fr.univpoitiers.croussardsapi.model.Review;
import fr.univpoitiers.croussardsapi.service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;


    @GetMapping("/restaurants/{id}")
    public ResponseEntity<?> getRestaurant(@PathVariable Long id) {
        Restaurant r = restaurantService.getRestaurant(id);
        return restaurantService.myResponse(r);
    }

    @GetMapping("/restaurants")
    public ResponseEntity<?> getRestaurants() {
        Iterable<Restaurant> restaurants = restaurantService.getRestaurants();
        return restaurantService.myResponse(restaurants);
    }

    @GetMapping("/restaurants/{id}/reviews")
    public ResponseEntity<?> getReviewsByRestaurant(@PathVariable Long id) {
        Iterable<Review> reviews_restaurant = restaurantService.getReviewsByRestaurant(id);
        return restaurantService.myResponse(reviews_restaurant);
    }

    @PostMapping("/restaurants")
    public ResponseEntity<?> addRestaurant(@Valid @RequestBody Restaurant restaurant) {
        restaurantService.saveRestaurant(restaurant);
        return restaurantService.myResponse(restaurant);
    }

    @PutMapping("/restaurants/{id}")
    public ResponseEntity<?> updateRestaurant(@PathVariable Long id, @Valid @RequestBody Restaurant restaurant) {
        Restaurant updateRestaurant = restaurantService.getRestaurant(id);
        restaurantService.updateRestaurant(updateRestaurant, restaurant);
        restaurantService.saveRestaurant(updateRestaurant);
        return restaurantService.myResponse(updateRestaurant);
    }

    @DeleteMapping("/restaurants/{id}")
    public ResponseEntity<?> deleteRestaurant(@PathVariable Long id){
        Restaurant restaurant = restaurantService.getRestaurant(id);
        restaurantService.deleteRestaurant(id);
        return restaurantService.myResponse(restaurant);
    }


}
