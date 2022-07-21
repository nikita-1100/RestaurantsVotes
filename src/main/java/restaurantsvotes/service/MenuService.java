package restaurantsvotes.service;


import restaurantsvotes.entity.Menu;

import java.util.List;

public interface MenuService {
    public void saveToBD(Menu menu);
    public List<Menu> getAll();
}
