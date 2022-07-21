package restaurantsvotes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import restaurantsvotes.entity.Restaurant;
import restaurantsvotes.entity.User;
import restaurantsvotes.service.RestaurantService;
import restaurantsvotes.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/create")
    public HttpStatus create(@RequestBody Restaurant restaurant){
        restaurantService.saveToBD(restaurant);
        return HttpStatus.CREATED;
    }

    @GetMapping()
    public List<Restaurant> getAll(){
        return restaurantService.getAll();
    }

    @GetMapping("/{id}")
    public Restaurant get(@PathVariable Integer id){
        return restaurantService.get(id);
    }
}
