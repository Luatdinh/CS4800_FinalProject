import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.List;

public class RestaurantTest {

    private CPPFoodDeliveryPlatform platform;
    private Restaurant restaurant;

    @BeforeEach
    public void setUp() {
        platform = new CPPFoodDeliveryPlatform();
        restaurant = new Restaurant("The Green Bowl", "123 Veggie Road", "LA County", LocalTime.of(8, 0), LocalTime.of(22, 0), "Vegan", platform);
    }

    @Test
    public void testRestaurantInitialization() {
        assertEquals("The Green Bowl", restaurant.getName());
        assertEquals("123 Veggie Road", restaurant.getAddress());
        assertEquals("LA County", restaurant.getCounty());
        assertEquals(LocalTime.of(8, 0), restaurant.getOpeningTime());
        assertEquals(LocalTime.of(22, 0), restaurant.getClosingTime());
        assertEquals("Vegan", restaurant.getCuisineType());
    }

    @Test
    public void testSetName() {
        restaurant.setName("New Green Bowl");
        assertEquals("New Green Bowl", restaurant.getName());
    }

    @Test
    public void testSetAddress() {
        restaurant.setAddress("456 Green Street");
        assertEquals("456 Green Street", restaurant.getAddress());
    }

    @Test
    public void testSetCounty() {
        restaurant.setCounty("Orange County");
        assertEquals("Orange County", restaurant.getCounty());
    }

    @Test
    public void testSetOpeningTime() {
        restaurant.setOpeningTime(LocalTime.of(9, 0));
        assertEquals(LocalTime.of(9, 0), restaurant.getOpeningTime());
    }

    @Test
    public void testSetClosingTime() {
        restaurant.setClosingTime(LocalTime.of(21, 0));
        assertEquals(LocalTime.of(21, 0), restaurant.getClosingTime());
    }

    @Test
    public void testSetCuisineType() {
        restaurant.setCuisineType("Italian");
        assertEquals("Italian", restaurant.getCuisineType());
    }

    @Test
    public void testPrepareDietaryMeals() {
        List<Meal> meals = restaurant.getMeals();
        assertEquals(4, meals.size());
    }

    @Test
    public void testCreateMealForDiet() {
        restaurant.createMealForDiet("Gluten Free");
        assertEquals(5, restaurant.getMeals().size());
    }

    @Test
    public void testPrepareMeal() {
        restaurant.prepareMeal();

    }
}
