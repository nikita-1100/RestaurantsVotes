package restaurantsvotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurantsvotes.entity.User;

public interface UserJpaRepository extends JpaRepository<User, Integer> {
}
