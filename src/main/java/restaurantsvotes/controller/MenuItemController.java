package restaurantsvotes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import restaurantsvotes.dto.MenuItemDto;
import restaurantsvotes.entity.MenuItem;
import restaurantsvotes.service.MenuItemService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MenuItemController {
    private final MenuItemService menuItemService;

    @GetMapping("/user/menu-items")
    public List<MenuItem> getMenuByDate(){
        return menuItemService.getMenuByDate();
    }

    @PostMapping("/admin/menu-item")
    @CacheEvict(value = "menu_item", allEntries = true)
    public HttpStatus addMenu(@RequestBody MenuItemDto menu){
        return menuItemService.addMenu(menu);
    }

    @DeleteMapping("/admin/menu-item/{id}")
    @CacheEvict(value="menu_item", allEntries = true)
    public HttpStatus deleteMenu(@PathVariable Integer id){
        return menuItemService.deleteMenu(id);
    }

    @PutMapping("/admin/menu-item/{id}")
    @CacheEvict(value = "menu_item", allEntries = true)
    public HttpStatus updateMenu(@RequestBody MenuItemDto menu, @PathVariable Integer id){
        return menuItemService.updateMenu(menu, id);
    }
}
