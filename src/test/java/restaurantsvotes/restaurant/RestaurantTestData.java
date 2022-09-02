package restaurantsvotes.restaurant;

import restaurantsvotes.JsonUtil;
import restaurantsvotes.entity.Restaurant;

public class RestaurantTestData {
    public static final String TOKIO_CITY = JsonUtil.getJson(new Restaurant(1,"Tokio city"));
    public static final Restaurant TOKIO_CITY_RESTAURANT = new Restaurant(1,"Tokio city");
}
