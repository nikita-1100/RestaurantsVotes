package restaurantsvotes.service;

import restaurantsvotes.entity.Restaurant;
import restaurantsvotes.entity.User;

import java.util.List;

public interface RestaurantService {
    public void saveToBD(Restaurant restaurant);
    public List<Restaurant> getAll();
    public Restaurant get(Integer id);
}
