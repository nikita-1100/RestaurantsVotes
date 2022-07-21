package restaurantsvotes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import restaurantsvotes.entity.Menu;
import restaurantsvotes.entity.Restaurant;
import restaurantsvotes.service.MenuService;
import restaurantsvotes.service.RestaurantService;
import restaurantsvotes.util.Tuple;


import java.util.List;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {
    @Autowired
    private MenuService menuService;

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/create")
    public HttpStatus create(@RequestBody Tuple<Menu,Integer> menuIntegerPair){
        Menu menu = menuIntegerPair.getKey();
        menu.setRestaurant(restaurantService.get(menuIntegerPair.getValue()));
        menuService.saveToBD(menu);
        return HttpStatus.CREATED;
    }

    @GetMapping()
    public List<Menu> getAll(){
        return menuService.getAll();
    }
}


