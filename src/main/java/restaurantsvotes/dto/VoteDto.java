package restaurantsvotes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import restaurantsvotes.entity.User;


import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class VoteDto {
    //private Integer userId;
    private User user;
    private LocalDate date;
    private String restaurantName;
}
