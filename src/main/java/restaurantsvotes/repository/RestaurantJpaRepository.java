package restaurantsvotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurantsvotes.entity.Restaurant;

public interface RestaurantJpaRepository extends JpaRepository<Restaurant,Integer> {
}
