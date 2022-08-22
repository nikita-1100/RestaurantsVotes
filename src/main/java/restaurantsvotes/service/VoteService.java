package restaurantsvotes.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurantsvotes.dto.DateDto;
import restaurantsvotes.dto.VoteDto;
import restaurantsvotes.entity.User;
import restaurantsvotes.entity.Vote;
import restaurantsvotes.repository.VoteJpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VoteService {
    @Autowired
    private VoteJpaRepository voteJpaRepository;

    @Autowired
    UserService userService;

    @Autowired
    RestaurantService restaurantService;






    @Transactional
    public void save(VoteDto voteDto) {
//        Vote foundedVote = voteJpaRepository.findByUserAndDate(voteDto.getUser(),voteDto.getDate());
        LocalDateTime voteDateTime = voteDto.getDate().atStartOfDay();//.plusHours(11);
//        if (voteDateTime.isAfter(LocalDateTime.now())){



        Vote vote = new Vote();
        vote.setUser(voteDto.getUser());
        vote.setDate(voteDto.getDate());

        //if (voteDto.getDate().isAfter(LocalDateTime.now().toLocalDate()) |  (voteDto.getDate().isEqual(LocalDateTime.now().toLocalDate()) & LocalDateTime.now().getHour()<11)){
            if (voteDto.getDate().isAfter(LocalDateTime.now().toLocalDate())){
                vote.setRestaurant(restaurantService.get(voteDto.getRestaurantName()));
            if (voteJpaRepository.findByUserAndDate(voteDto.getUser(),voteDto.getDate())==null){
                voteJpaRepository.save(vote);
            } else {
                voteJpaRepository.updateVote(vote.getRestaurant(),vote.getUser(),vote.getDate());
            }
        }
    }



    public String getRestaurantForDate(DateDto date) {
        return voteJpaRepository.getRestaurantForDate(date.getDate());
    }




}
