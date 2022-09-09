package restaurantsvotes.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurantsvotes.entity.MenuItem;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface MenuItemJpaRepository extends JpaRepository<MenuItem, Integer> {
    @Cacheable("menu_item")
    List<MenuItem> findMenuByDate(LocalDate date);
}
