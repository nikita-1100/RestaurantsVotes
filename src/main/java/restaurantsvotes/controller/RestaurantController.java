package restaurantsvotes.controller;



import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import restaurantsvotes.entity.Restaurant;
import restaurantsvotes.repository.RestaurantJpaRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantJpaRepository restaurantRepo;
    @PostMapping("/admin/restaurant")
    public HttpStatus addRestaurant(@RequestBody Restaurant restaurant){
        restaurantRepo.save(restaurant);
        return HttpStatus.CREATED;
    }

    @GetMapping("/admin/restaurants")
    public List<Restaurant> getAllRestaurants(){
        return restaurantRepo.findAll();
    }

    @GetMapping("/admin/restaurant/{id}")
    public Restaurant get(@PathVariable int id){
        return restaurantRepo.findById(id).get();
    }

    @DeleteMapping("/admin/restaurant/{id}")
    public HttpStatus deleteRestaurant(@PathVariable int id){
        restaurantRepo.deleteById(id);
        return HttpStatus.CREATED;
    }

    @PutMapping("/admin/restaurant/{id}")
    public HttpStatus updateMenu(@RequestBody Restaurant restaurant, @PathVariable Integer id){
        if (restaurantRepo.findById(id).equals(Optional.empty()))
            return HttpStatus.CONFLICT;
        restaurant.setId(id);
        restaurantRepo.save(restaurant);
        return HttpStatus.CREATED;
    }
}
