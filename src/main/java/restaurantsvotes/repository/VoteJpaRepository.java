package restaurantsvotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import restaurantsvotes.entity.Restaurant;
import restaurantsvotes.entity.User;
import restaurantsvotes.entity.Vote;

import java.time.LocalDate;

@Repository
public interface VoteJpaRepository extends JpaRepository<Vote,Integer> {
    String winnerInDateSqlQuery = "select name " +
            "from restaurant " +
            "where name in " +
                "(select restaurant_name " +
                "from vote " +
                "where date=(:date) " +
                "group by restaurant_name " +
                "order by count(restaurant_name) desc " +
                "limit 1)";

    @Query(value = winnerInDateSqlQuery, nativeQuery = true)
    String getRestaurantForDate(LocalDate date);

    Vote findByUserAndDate(User user, LocalDate date);

    @Modifying
    @Query("update Vote v set v.restaurant = ?1 where v.user = ?2 and v.date=?3")
    void updateVote(Restaurant restaurant, User user, LocalDate date);

}
