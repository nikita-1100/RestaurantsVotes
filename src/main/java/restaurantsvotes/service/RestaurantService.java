package restaurantsvotes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurantsvotes.entity.Restaurant;
import restaurantsvotes.repository.RestaurantJpaRepository;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantJpaRepository restaurantJpaRepository;


    @Transactional
    public void save(Restaurant restaurant) {
        restaurantJpaRepository.save(restaurant);
    }

    public Restaurant get(String name){
        return restaurantJpaRepository.findById(name).orElseThrow();
    }

}
