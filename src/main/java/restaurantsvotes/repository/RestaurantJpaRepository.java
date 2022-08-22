package restaurantsvotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurantsvotes.entity.Restaurant;
@Repository
public interface RestaurantJpaRepository extends JpaRepository<Restaurant,String> {
}
