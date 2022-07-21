package restaurantsvotes.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurantsvotes.entity.Menu;
import restaurantsvotes.entity.Restaurant;
import restaurantsvotes.repository.MenuJpaRepository;
import restaurantsvotes.repository.RestaurantJpaRepository;
import restaurantsvotes.service.MenuService;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuJpaRepository menuJpaRepository;

    @Override
    @Transactional
    public void saveToBD(Menu menu) {
        menuJpaRepository.save(menu);
    }

    @Override
    public List<Menu> getAll() {
        return menuJpaRepository.findAll();
    }
}
