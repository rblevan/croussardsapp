package fr.univ_poitiers.croussards;


import fr.univ_poitiers.croussards.model.Restaurant;
import fr.univpoitiers.croussardsback.repository.RestaurantRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class RestaurantRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Test
    void whenFindById_thenReturnRestaurant() {
        // nouveau restaurant à sauvegarder
        Restaurant restaurant = new Restaurant();
        restaurant.setName("Le Crous'tille");
        restaurant.setAddress("123 Rue de la Faim, Poitiers");
        restaurant.setType_resto("Universitaire");
        entityManager.persistAndFlush(restaurant);

        // retrouver le restaurant par son ID
        Optional<Restaurant> found = restaurantRepository.findById(restaurant.getId_resto());

        //Vérifie que le restaurant a été trouvé et que ses données sont correctes
        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo(restaurant.getName());
        assertThat(found.get().getAddress()).isEqualTo(restaurant.getAddress());
    }
}
