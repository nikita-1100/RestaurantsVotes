package restaurantsvotes.controller;



import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import restaurantsvotes.entity.Menu;
import restaurantsvotes.entity.Restaurant;
import restaurantsvotes.repository.RestaurantJpaRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantJpaRepository restaurantRepo;
    @PostMapping("/admin/restaurants")
    public HttpStatus addRestaurant(@RequestBody Restaurant restaurant){
        restaurantRepo.save(restaurant);
        return HttpStatus.CREATED;
    }



    @GetMapping("/admin/restaurants")
    public List<Restaurant> getAllRestaurants(){
        return restaurantRepo.findAll();
    }

    @DeleteMapping("/admin/restaurants/{id}")
    public HttpStatus deleteRestaurant(@PathVariable int id){
        restaurantRepo.deleteById(id);
        return HttpStatus.CREATED;
    }

    @PutMapping("/admin/restaurants/{id}")
    public HttpStatus updateMenu(@RequestBody Restaurant restaurant, @PathVariable Integer id){
        if (restaurantRepo.findById(id).equals(Optional.empty()))
            return HttpStatus.CONFLICT;
        restaurant.setId(id);
        restaurantRepo.save(restaurant);
        return HttpStatus.CREATED;
    }
}
