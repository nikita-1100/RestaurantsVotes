package restaurantsvotes;

import org.springframework.data.util.Pair;
import restaurantsvotes.entity.Menu;
import restaurantsvotes.entity.Restaurant;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Difference {
    public static void main(String[] args) {
        String dateS = "2020-12-30";
        LocalDate date = LocalDate.parse(dateS, DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(date);

    }

}
