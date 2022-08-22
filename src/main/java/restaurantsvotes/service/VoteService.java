package restaurantsvotes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurantsvotes.dto.DateDto;
import restaurantsvotes.dto.VoteDto;
import restaurantsvotes.entity.Vote;
import restaurantsvotes.repository.RestaurantJpaRepository;
import restaurantsvotes.repository.VoteJpaRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class VoteService {

    private final VoteJpaRepository voteJpaRepository;
    private final RestaurantJpaRepository restaurantRepo;

    @Transactional
    public void save(VoteDto voteDto) {
        Vote vote = new Vote();
        vote.setUser(voteDto.getUser());
        vote.setDate(voteDto.getDate());

        if (voteDto.getDate().isAfter(LocalDateTime.now().toLocalDate())){
                vote.setRestaurant(restaurantRepo.findById(voteDto.getRestaurantName()).orElseThrow());
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
