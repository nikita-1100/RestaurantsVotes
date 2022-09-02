package restaurantsvotes.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurantsvotes.entity.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer> {
    @Cacheable("users")
    User findByName(String username);
}
