package restaurantsvotes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import restaurantsvotes.dto.VoteDto;
import restaurantsvotes.service.VoteService;

@RestController
@RequiredArgsConstructor
public class VoteController {

    private final VoteService voteService;

    @PostMapping("/user/votes")
    public HttpStatus vote(@RequestBody VoteDto voteDto){
        voteService.save(voteDto);
        return HttpStatus.CREATED;
    }

    @GetMapping("/admin/votes/winner-restaurant/{dateString}")
    public String getVotes(@PathVariable String dateString){
        return voteService.getRestaurantForDate(dateString);
    }


}
