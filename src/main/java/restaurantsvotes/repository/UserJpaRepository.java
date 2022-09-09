package restaurantsvotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurantsvotes.entity.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer> {
    User findByName(String username);
}
