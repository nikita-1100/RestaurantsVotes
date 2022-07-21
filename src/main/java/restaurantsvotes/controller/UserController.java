package restaurantsvotes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import restaurantsvotes.entity.User;
import restaurantsvotes.repository.UserJpaRepository;
import restaurantsvotes.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public HttpStatus create(@RequestBody User user){
        userService.saveToBD(user);
        return HttpStatus.CREATED;
    }

    @GetMapping()
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User get(@PathVariable Integer id){
        return userService.get(id);
    }
}
