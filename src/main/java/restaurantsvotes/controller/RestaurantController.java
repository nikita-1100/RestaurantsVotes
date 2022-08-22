package restaurantsvotes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import restaurantsvotes.entity.Restaurant;
import restaurantsvotes.repository.RestaurantJpaRepository;

@RestController
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantJpaRepository restaurantRepo;
    @PostMapping("/admin/add-restaurant")
    public HttpStatus addRestaurant(@RequestBody Restaurant restaurant){
        restaurantRepo.save(restaurant);
        return HttpStatus.CREATED;
    }



}
