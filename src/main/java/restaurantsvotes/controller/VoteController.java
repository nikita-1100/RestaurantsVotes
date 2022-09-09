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

    @PostMapping("/user/vote")
    public HttpStatus vote(@RequestBody VoteDto voteDto){
        voteService.save(voteDto);
        return HttpStatus.CREATED;
    }

    @GetMapping("/admin/vote/winner-restaurant/{dateString}")
    public String getRestaurantForDate(@PathVariable String dateString){
        return voteService.getRestaurantForDate(dateString);
    }


}
