package restaurantsvotes.menu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import restaurantsvotes.AbstractControllerTest;
import restaurantsvotes.repository.MenuJpaRepository;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MenuControllerTest extends AbstractControllerTest {
    @Autowired
    MenuJpaRepository menuRepository;

    @Test
    @WithUserDetails("user")
    void getAll() throws Exception {
        perform(MockMvcRequestBuilders.get("/user/menus"))
                .andExpect(status().isOk());
    }

    @Test
    @WithUserDetails("user")
    void getAllUser() throws Exception {
        perform(MockMvcRequestBuilders.get("/admin/menus"))
                .andExpect(status().isForbidden());
    }

    @Test
    void getAllNoUser() throws Exception {
        perform(MockMvcRequestBuilders.get("/admin/menus"))
                .andExpect(status().isUnauthorized());
    }


}
