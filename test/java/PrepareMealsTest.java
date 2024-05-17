import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PrepareMealsTest {

    private CPPFoodDeliveryPlatform platform;
    private PrepareMeals prepareMeals;

    @BeforeEach
    public void setUp() {
        platform = new CPPFoodDeliveryPlatform();
        prepareMeals = new PrepareMeals();

        // Adding restaurants
        platform.registerRestaurant(new Restaurant("The Green Bowl", "123 Veggie Road", "LA County", LocalTime.of(8, 0), LocalTime.of(22, 0), "Vegan", platform));
        platform.registerRestaurant(new Restaurant("Ocean's Catch", "234 Fish Ave", "Orange County", LocalTime.of(10, 0), LocalTime.of(20, 0), "Seafood", platform));
    }

    @Test
    public void testPrepareMeals_Success() {
        platform.setDietaryRestrictions("Vegan");
        platform.setTopping("Tomato");
        platform.setOrderTime(LocalTime.of(12, 0));
        platform.setSelectedRestaurantName("The Green Bowl");

        prepareMeals.prepareMeals(platform);

        assertNotNull(platform.getCurrentMeal());
    }

    @Test
    public void testPrepareMeals_Failure_ClosedRestaurant() {
        platform.setDietaryRestrictions("Vegan");
        platform.setTopping("Tomato");
        platform.setOrderTime(LocalTime.of(23, 0));
        platform.setSelectedRestaurantName("The Green Bowl");

        prepareMeals.prepareMeals(platform);

        assertNull(platform.getCurrentMeal());
    }

    @Test
    public void testPrepareMeals_NoDietaryRestrictions() {
        platform.setTopping("Tomato");
        platform.setOrderTime(LocalTime.of(12, 0));
        platform.setSelectedRestaurantName("The Green Bowl");

        assertNull(platform.getCurrentMeal());
    }

    @Test
    public void testPrepareMeals_NoTopping() {
        platform.setDietaryRestrictions("Vegan");
        platform.setOrderTime(LocalTime.of(12, 0));
        platform.setSelectedRestaurantName("The Green Bowl");

        assertNull(platform.getCurrentMeal());
    }
}
