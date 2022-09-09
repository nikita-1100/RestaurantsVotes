package restaurantsvotes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import restaurantsvotes.entity.Restaurant;
import restaurantsvotes.entity.User;
import restaurantsvotes.repository.UserJpaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserJpaRepository userRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public HttpStatus saveUser(User user) {
        User userFromDB = userRepository.findByName(user.getUsername());
        if (userFromDB != null) {
            return HttpStatus.CONFLICT;
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return HttpStatus.CREATED;
    }

    public HttpStatus updateUser(User user, Integer id) {
        if (userRepository.findById(id).equals(Optional.empty()))
            return HttpStatus.CONFLICT;
        user.setId(id);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return HttpStatus.CREATED;
    }


    public List<User> getAllUsers(){
        List<User> users = userRepository.findAll();
        for (User user: users) {
            user.setPassword("*****");
        }
        return users;
    }

    public HttpStatus deleteUser(Integer id){
        if (userRepository.findById(id).equals(Optional.empty()))
            return HttpStatus.CONFLICT;
        userRepository.deleteById(id);
        return HttpStatus.CREATED;
    }

}

