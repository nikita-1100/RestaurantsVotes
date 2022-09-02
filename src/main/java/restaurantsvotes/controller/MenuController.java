package restaurantsvotes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import restaurantsvotes.entity.Menu;
import restaurantsvotes.repository.MenuJpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MenuController {
    private final MenuJpaRepository menuRepo;

    @GetMapping("/user/menus")
    public List<Menu> getMenuByDate(){
        return menuRepo.findMenuByDate(LocalDate.now());
    }

    @PostMapping("/admin/menus")
    @CacheEvict(value = "menu", allEntries = true)
    public HttpStatus addMenu(@RequestBody Menu menu){
        menuRepo.save(menu);
        return HttpStatus.CREATED;
    }

    @DeleteMapping("/admin/menus/{id}")
    @CacheEvict(value="menu", allEntries = true)
    public HttpStatus deleteMenu(@PathVariable Integer id){
        menuRepo.deleteById(id);
        return HttpStatus.NO_CONTENT;
    }

    @PutMapping("/admin/menus/{id}")
    @CacheEvict(value = "menu", allEntries = true)
    public HttpStatus updateMenu(@RequestBody Menu menu, @PathVariable Integer id){
        if (menuRepo.findById(id).equals(Optional.empty()))
            return HttpStatus.CONFLICT;
        menu.setId(id);
        menuRepo.save(menu);
        return HttpStatus.CREATED;
    }
}
