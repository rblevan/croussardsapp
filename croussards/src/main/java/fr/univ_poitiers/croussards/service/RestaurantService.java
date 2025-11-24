package fr.univ_poitiers.croussards.service;

import fr.univ_poitiers.croussards.model.Restaurant;
import fr.univ_poitiers.croussards.repository.RestaurantRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
public class RestaurantService {
    @Autowired
    private static RestaurantRepository restaurantRepository;

    public static Optional<Restaurant> getRestaurant(final Long id) {
        return restaurantRepository.findById(id);
    }

    public Iterable<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }
}
