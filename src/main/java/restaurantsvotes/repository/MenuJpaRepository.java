package restaurantsvotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurantsvotes.entity.Menu;

public interface MenuJpaRepository extends JpaRepository<Menu, Integer> {
}
