package restaurantsvotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurantsvotes.entity.Vote;

public interface VoteJpaRepository extends JpaRepository<Vote,Integer> {
}
