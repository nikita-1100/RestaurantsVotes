package restaurantsvotes.entity.inputEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;


@AllArgsConstructor
@Getter
public class InputVote {
    private int user_id;
    private LocalDate date;
    private int restaurant_id;
}
