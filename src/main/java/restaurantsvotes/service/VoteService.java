package restaurantsvotes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class VoteService {
    private final VoteJpaRepository voteJpaRepository;
    private final RestaurantJpaRepository restaurantRepo;

    @Transactional
    public HttpStatus save(VoteDto voteDto) {
        Vote vote = new Vote();
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        vote.setUser(currentUser);
        vote.setRestaurant(restaurantRepo.findById(voteDto.getRestaurantId()).orElseThrow());
        vote.setDate(LocalDate.now());

        if (LocalDateTime.now().getHour()>19)
            return HttpStatus.CONFLICT;
        if (voteJpaRepository.findByUserAndDate(currentUser,LocalDate.now())==null)
            voteJpaRepository.save(vote);
        else
            voteJpaRepository.updateVote(vote.getRestaurant(),vote.getUser(),vote.getDate());
        return HttpStatus.CREATED;
    }

    public String getRestaurantForDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateString, formatter);
        return voteJpaRepository.getRestaurantForDate(date);
    }

}
