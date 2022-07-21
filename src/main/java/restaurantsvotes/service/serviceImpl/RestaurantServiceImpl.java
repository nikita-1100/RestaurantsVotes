package restaurantsvotes.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurantsvotes.entity.Restaurant;
import restaurantsvotes.repository.RestaurantJpaRepository;
import restaurantsvotes.service.RestaurantService;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantJpaRepository restaurantJpaRepository;

    @Override
    @Transactional
    public void saveToBD(Restaurant restaurant) {
        restaurantJpaRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAll() {
        return restaurantJpaRepository.findAll();
    }

    @Override
    public Restaurant get(Integer id) {
        return restaurantJpaRepository.findById(id).orElseThrow();
    }
}
