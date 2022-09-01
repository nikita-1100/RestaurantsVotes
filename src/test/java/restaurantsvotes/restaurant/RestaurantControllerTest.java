package restaurantsvotes.restaurant;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import restaurantsvotes.AbstractControllerTest;
import restaurantsvotes.repository.RestaurantJpaRepository;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RestaurantControllerTest extends AbstractControllerTest{
    private static final String REST_URL = RestaurantControllerTest.REST_URL + '/';

    @Autowired
    private RestaurantJpaRepository restaurantRepo;

    @Test
    void get() throws Exception{

    }



}
