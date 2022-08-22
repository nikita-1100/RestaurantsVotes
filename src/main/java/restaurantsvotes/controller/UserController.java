package restaurantsvotes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import restaurantsvotes.entity.Role;
import restaurantsvotes.entity.User;
import restaurantsvotes.service.UserService;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("admin/registration")
    public void addUser(@RequestBody User user) {
        Set<Role> roles = new HashSet<>();
        roles.add(user.getUsername().contains("_adm")?Role.ADMIN:Role.USER);
        user.setRoles(roles);
        userService.saveUser(user);
    }



}
