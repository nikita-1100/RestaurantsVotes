package restaurantsvotes.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurantsvotes.entity.User;
import restaurantsvotes.repository.UserJpaRepository;
import restaurantsvotes.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserJpaRepository userJpaRepository;

    @Override
    @Transactional
    public void saveToBD(User user) {
        userJpaRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userJpaRepository.findAll();
    }

    @Override
    public User get(Integer id) {
        return userJpaRepository.findById(id).orElseThrow();
    }
}
