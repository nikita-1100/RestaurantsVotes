package restaurantsvotes.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurantsvotes.entity.Menu;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MenuJpaRepository extends JpaRepository<Menu, Integer> {
    @Cacheable("menu")
    List<Menu> findMenuByDate(LocalDate date);
}
