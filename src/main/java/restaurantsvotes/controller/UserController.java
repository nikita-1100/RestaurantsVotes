package restaurantsvotes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import restaurantsvotes.entity.User;
import restaurantsvotes.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("admin/user")
    public HttpStatus addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("admin/user/{id}")
    public HttpStatus deleteUser(@PathVariable Integer id){
        return userService.deleteUser(id);
    }

    @PutMapping("admin/user/{id}")
    public HttpStatus updateUser(@RequestBody User user, @PathVariable Integer id){
        return userService.updateUser(user,id);
    }

    @GetMapping("admin/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

}
