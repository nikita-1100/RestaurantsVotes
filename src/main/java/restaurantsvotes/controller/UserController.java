package restaurantsvotes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import restaurantsvotes.entity.User;
import restaurantsvotes.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("admin/users")
    @CacheEvict(value="users", allEntries = true)
    public HttpStatus addUser(@RequestBody User user) {
        userService.saveUser(user);
        return HttpStatus.CREATED;
    }

    @DeleteMapping("admin/users/{id}")
    @CacheEvict(value="users", allEntries = true)
    public HttpStatus deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return HttpStatus.CREATED;
    }

}
