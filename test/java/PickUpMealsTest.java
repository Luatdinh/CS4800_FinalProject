import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PickUpMealsTest {

    private CPPFoodDeliveryPlatform platform;
    private PickUpMeals pickUpMeals;
    private Restaurant restaurant;
    private Driver driver;
    private Customer customer;

    @BeforeEach
    public void setUp() {
        platform = new CPPFoodDeliveryPlatform();
        pickUpMeals = new PickUpMeals();
        restaurant = new Restaurant("Test Restaurant", "123 Main St", "Test County", LocalTime.of(8, 0), LocalTime.of(22, 0), "Test Cuisine", platform);
        platform.registerRestaurant(restaurant);
        driver = new Driver("Test Driver", "456 Elm St", "Test County", LocalTime.of(8, 0), LocalTime.of(16, 0), platform);
        platform.registerDriver(driver);
        customer = new Customer("Test Customer", "789 Pine St", "Test County", platform);
        platform.registerCustomer(customer);
    }

    @Test
    public void testPickUpMeals_Success() {
        platform.setCurrentCustomer(customer);
        platform.setOrderTime(LocalTime.of(10, 0));
        platform.setPickUpTime(LocalTime.of(10, 30));
        platform.setSelectedRestaurantName(restaurant.getName());
        platform.setSelectedDriverName(driver.getName());
        platform.setDietaryRestrictions("None");
        platform.setTopping("Cheese");

        pickUpMeals.pickUpMeals(platform);


    }

    @Test
    public void testPickUpMeals_Failure_NoDrivers() {
        platform.getDrivers().clear(); // Clear all drivers

        pickUpMeals.pickUpMeals(platform);


    }

    @Test
    public void testPickUpMeals_Failure_DriverUnavailable() {
        platform.setCurrentCustomer(customer);
        platform.setOrderTime(LocalTime.of(10, 0));
        platform.setPickUpTime(LocalTime.of(18, 0)); // Time when the driver is unavailable
        platform.setSelectedRestaurantName(restaurant.getName());
        platform.setSelectedDriverName(driver.getName());
        platform.setDietaryRestrictions("None");
        platform.setTopping("Cheese");

        pickUpMeals.pickUpMeals(platform);

    }

    @Test
    public void testPickUpMeals_Failure_DriverInDifferentCounty() {
        driver.setOperatingCounty("Different County");

        platform.setCurrentCustomer(customer);
        platform.setOrderTime(LocalTime.of(10, 0));
        platform.setPickUpTime(LocalTime.of(10, 30));
        platform.setSelectedRestaurantName(restaurant.getName());
        platform.setSelectedDriverName(driver.getName());
        platform.setDietaryRestrictions("None");
        platform.setTopping("Cheese");

        pickUpMeals.pickUpMeals(platform);

    }
}
