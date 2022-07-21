package restaurantsvotes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import restaurantsvotes.entity.Vote;
import restaurantsvotes.entity.inputEntity.InputVote;
import restaurantsvotes.service.VoteService;

import java.util.List;

@RestController
@RequestMapping("/vote")
@RequiredArgsConstructor
public class VoteController {
    @Autowired
    private VoteService voteService;
    @Autowired
    private RestaurantController restaurantController;
    @Autowired
    private UserController userController;

    @PostMapping("/create")
    public HttpStatus create(@RequestBody InputVote inputVote){
        Vote vote = new Vote();
        vote.setDate(inputVote.getDate());
        vote.setUser(userController.get(inputVote.getUser_id()));
        vote.setRestaurant(restaurantController.get(inputVote.getRestaurant_id()));
        voteService.saveToBD(vote);
        return HttpStatus.CREATED;
    }

//    @PostMapping("/create")
//    public HttpStatus create(@RequestBody Tuple<Vote,Tuple<Integer,Integer>> voteUserRestaurant){
//        Vote vote = voteUserRestaurant.getKey();
//        vote.setRestaurant(restaurantService.get(voteUserRestaurant.getValue().getValue()));
//        vote.setUser(userService.get(voteUserRestaurant.getValue().getKey()));
//        voteService.saveToBD(vote);
//        return HttpStatus.CREATED;
////{
////    "key" : {
////    "date":"2020-12-30T00:00:00"
////},
////    "value" : {"key" : "1", "value" : "2"}
////}
//
////    }

    @GetMapping()
    public List<Vote> getAll(){
        return voteService.getAll();
    }
}
