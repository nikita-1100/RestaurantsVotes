package restaurantsvotes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import restaurantsvotes.dto.MenuItemDto;
import restaurantsvotes.entity.MenuItem;
import restaurantsvotes.repository.MenuItemJpaRepository;
import restaurantsvotes.repository.RestaurantJpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuItemService {
    private final MenuItemJpaRepository menuRepo;

    private final RestaurantJpaRepository restaurantRepository;

    public List<MenuItem> getMenuByDate(){
        return menuRepo.findMenuByDate(LocalDate.now());
    }

    @CacheEvict(value = "menu_item", allEntries = true)
    public HttpStatus addMenu(MenuItemDto menuDto){
        menuRepo.save(dtoToMenu(menuDto));
        return HttpStatus.CREATED;
    }


    @CacheEvict(value="menu_item", allEntries = true)
    public HttpStatus deleteMenu(Integer id){
        menuRepo.deleteById(id);
        return HttpStatus.NO_CONTENT;
    }


    @CacheEvict(value = "menu_item", allEntries = true)
    public HttpStatus updateMenu(MenuItemDto menuDto, Integer id){
        if (menuRepo.findById(id).equals(Optional.empty()))
            return HttpStatus.CONFLICT;
        MenuItem menuItem = dtoToMenu(menuDto);
        menuItem.setId(id);
        menuRepo.save(menuItem);
        return HttpStatus.CREATED;
    }

    private MenuItem dtoToMenu(MenuItemDto menuDto){
        return new MenuItem(null,restaurantRepository.findById(menuDto.getRestaurantId()).orElseThrow(),menuDto.getDishName(),menuDto.getPrice(),menuDto.getDate());
    }

}
