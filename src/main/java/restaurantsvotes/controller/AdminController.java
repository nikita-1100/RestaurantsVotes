package restaurantsvotes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurantsvotes.dto.DateDto;
import restaurantsvotes.entity.Role;
import restaurantsvotes.entity.User;
import restaurantsvotes.service.VoteService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    @Autowired
    private VoteService voteService;


    @GetMapping("/winnerInDate")
    public String getVotes(@RequestBody DateDto date){
        return voteService.getRestaurantForDate(date);
    }

    @GetMapping("/test")
    public String test(@AuthenticationPrincipal User user){
        return "Admin controller current user: "+ user.getName()
                + (user.getRoles().contains(Role.ADMIN)?" role:ADMIN":"role:USER");
    }
}
