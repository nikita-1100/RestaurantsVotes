package restaurantsvotes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MenuItemDto {
    private Integer restaurantId;
    private Integer price;
    private String dishName;
    private LocalDate date;
}
