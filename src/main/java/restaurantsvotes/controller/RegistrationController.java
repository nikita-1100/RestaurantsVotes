package restaurantsvotes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import restaurantsvotes.entity.Role;
import restaurantsvotes.entity.User;
import restaurantsvotes.service.UserService;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;


@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public void addUser(User user, Map<String, Object> model) {
        Set<Role> roles = new HashSet<>();
        roles.add(user.getUsername().contains("_adm")?Role.ADMIN:Role.USER);
        user.setRoles(roles);
        userService.saveUser(user);

    }

//    @GetMapping("/")
//    public String MainPage(@AuthenticationPrincipal User user){
//        return "Current user: "+ user.getName()
//                + (user.getRoles().contains(Role.ADMIN)?" role:ADMIN":" role:USER");
//    }


}

