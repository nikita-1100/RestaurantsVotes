package restaurantsvotes.vote;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import restaurantsvotes.AbstractControllerTest;
import restaurantsvotes.repository.VoteJpaRepository;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class VoteControllerTest extends AbstractControllerTest {
    @Autowired
    VoteJpaRepository voteRepository;

    @Test
    @WithUserDetails("user")
    void getResultByUser() throws Exception {
        perform(MockMvcRequestBuilders.get("/admin/votes/winner-restaurant/"+VoteTestData.DATA_1_AUG))
                .andExpect(status().isForbidden());
    }

    @Test
    void getResultByNoAuth() throws Exception {
        perform(MockMvcRequestBuilders.get("/admin/votes/winner-restaurant/"+VoteTestData.DATA_1_AUG))
                .andExpect(status().isUnauthorized());
    }


    @Test
    @WithUserDetails("admin")
    void getWinner1() throws Exception {
        perform(MockMvcRequestBuilders.get("/admin/votes/winner-restaurant/"+VoteTestData.DATA_1_AUG))
                .andExpect(content().string(containsString(VoteTestData.DATA_1_AUG_RESTAURANT_WINNER)));
    }

    @Test
    @WithUserDetails("admin")
    void getWinner2() throws Exception {
        perform(MockMvcRequestBuilders.get("/admin/votes/winner-restaurant/"+VoteTestData.DATA_2_AUG))
                .andExpect(content().string(containsString(VoteTestData.DATA_2_AUG_RESTAURANT_WINNER)));
    }

    @Test
    @WithUserDetails("admin")
    void getWinner3() throws Exception {
        perform(MockMvcRequestBuilders.get("/admin/votes/winner-restaurant/"+VoteTestData.DATA_3_AUG))
                .andExpect(content().string(containsString(VoteTestData.DATA_3_AUG_RESTAURANT_WINNER)));
    }

    @Test
    @WithUserDetails("admin")
    void getWinner4() throws Exception {
        perform(MockMvcRequestBuilders.get("/admin/votes/winner-restaurant/"+VoteTestData.DATA_4_AUG))
                .andExpect(content().string(containsString(VoteTestData.DATA_4_AUG_RESTAURANT_WINNER)));
    }

    @Test
    @WithUserDetails("admin")
    void getWinner5() throws Exception {
        perform(MockMvcRequestBuilders.get("/admin/votes/winner-restaurant/"+VoteTestData.DATA_5_AUG))
                .andExpect(content().string(containsString(VoteTestData.DATA_5_AUG_RESTAURANT_WINNER)));
    }





}
