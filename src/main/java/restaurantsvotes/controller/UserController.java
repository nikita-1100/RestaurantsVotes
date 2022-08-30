package restaurantsvotes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import restaurantsvotes.entity.Role;
import restaurantsvotes.entity.User;
import restaurantsvotes.service.UserService;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("admin/users")
    @CacheEvict(value="users", allEntries = true)
    public HttpStatus addUser(@RequestBody User user) {
//        Set<Role> roles = new HashSet<>();
//        roles.add(user.getUsername().contains("_adm")?Role.ADMIN:Role.USER);
//        user.setRoles(roles);
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
