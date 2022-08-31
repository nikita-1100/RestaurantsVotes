package restaurantsvotes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurantsvotes.dto.DateDto;
import restaurantsvotes.dto.VoteDto;
import restaurantsvotes.entity.User;
import restaurantsvotes.entity.Vote;
import restaurantsvotes.repository.RestaurantJpaRepository;
import restaurantsvotes.repository.VoteJpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class VoteService {
    private final VoteJpaRepository voteJpaRepository;
    private final RestaurantJpaRepository restaurantRepo;

    @Transactional
    public HttpStatus save(VoteDto voteDto) {
        Vote vote = new Vote();
        vote.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        vote.setRestaurant(restaurantRepo.findById(voteDto.getRestaurantName()).orElseThrow());
        vote.setDate(LocalDate.now());

        if (LocalDateTime.now().getHour()>23)
            return HttpStatus.CONFLICT;
        if (voteJpaRepository.findByUserAndDate(voteDto.getUser(),LocalDate.now())==null)
            voteJpaRepository.save(vote);
        else
            voteJpaRepository.updateVote(vote.getRestaurant(),vote.getUser(),vote.getDate());
        return HttpStatus.CREATED;
    }

    public String getRestaurantForDate(DateDto date) {
        return voteJpaRepository.getRestaurantForDate(date.getDate());
    }

}
