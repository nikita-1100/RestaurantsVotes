package restaurantsvotes.restaurant;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import restaurantsvotes.AbstractControllerTest;
import restaurantsvotes.repository.RestaurantJpaRepository;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RestaurantControllerTest extends AbstractControllerTest {


    @Autowired
    RestaurantJpaRepository restaurantRepository;

    @Test
    @WithUserDetails("admin")
    void getAll() throws Exception {
        perform(MockMvcRequestBuilders.get("/admin/restaurants"))
                .andExpect(status().isOk());
    }

    @Test
    @WithUserDetails("user")
    void getAllUser() throws Exception {
        perform(MockMvcRequestBuilders.get("/admin/restaurants"))
                .andExpect(status().isForbidden());
    }

    @Test
    void getAllNoUser() throws Exception {
        perform(MockMvcRequestBuilders.get("/admin/restaurants"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithUserDetails("admin")
    void getRestaurant() throws Exception {
        perform(MockMvcRequestBuilders.get("/admin/restaurants/1"))
                .andExpect(content().string(containsString(RestaurantTestData.TOKIO_CITY)));
    }
}
