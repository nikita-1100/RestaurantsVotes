package restaurantsvotes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import restaurantsvotes.dto.DateDto;
import restaurantsvotes.entity.Menu;
import restaurantsvotes.repository.MenuJpaRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MenuController {

    private final MenuJpaRepository menuRepo;

    @GetMapping("/user/menu")
    public List<Menu> getMenuByDate(@RequestBody DateDto dateDto){
        return menuRepo.findMenuByDate(dateDto.getDate());
    }

    @PostMapping("/admin/add-menu")
    public HttpStatus addMenu(@RequestBody Menu menu){
        menuRepo.save(menu);
        return HttpStatus.CREATED;
    }

}
