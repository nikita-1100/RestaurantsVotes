package restaurantsvotes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import restaurantsvotes.dto.DateDto;
import restaurantsvotes.dto.VoteDto;
import restaurantsvotes.entity.User;
import restaurantsvotes.service.VoteService;

@RestController
@RequiredArgsConstructor
public class VoteController {

    private final VoteService voteService;

    @PostMapping("/user/vote")
    public HttpStatus vote(@RequestBody VoteDto voteDto, @AuthenticationPrincipal User user){
        voteDto.setUser(user);
        voteService.save(voteDto);
        return HttpStatus.CREATED;
    }

    @GetMapping("/admin/winnerInDate")
    public String getVotes(@RequestBody DateDto date){
        return voteService.getRestaurantForDate(date);
    }


}
