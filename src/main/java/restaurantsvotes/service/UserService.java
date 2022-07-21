package restaurantsvotes.service;

import restaurantsvotes.entity.User;

import java.util.List;

public interface UserService {
    public void saveToBD(User user);
    public List<User> getAll();
    public User get(Integer id);
}
