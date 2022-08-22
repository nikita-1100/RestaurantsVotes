package restaurantsvotes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import restaurantsvotes.dto.DateDto;
import restaurantsvotes.dto.VoteDto;
import restaurantsvotes.entity.Menu;
import restaurantsvotes.entity.Role;
import restaurantsvotes.entity.User;
import restaurantsvotes.repository.MenuJpaRepository;
import restaurantsvotes.service.VoteService;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private VoteService voteService;

    @Autowired
    private MenuJpaRepository menuRepo;

    @PostMapping("/vote")
    public HttpStatus vote(@RequestBody VoteDto voteDto, @AuthenticationPrincipal User user){
        voteDto.setUser(user);
        voteService.save(voteDto);
        return HttpStatus.CREATED;
    }

    @GetMapping("/menu")
    public List<Menu> getMenuByDate(DateDto dateDto){
        return menuRepo.findMenuByDate(dateDto.getDate());
    }

    @GetMapping("/test")
    public String test(@AuthenticationPrincipal User user){
        return "User controller current user: "+ user.getName()
                + (user.getRoles().contains(Role.ADMIN)?" role:ADMIN":" role:USER");
    }

}
