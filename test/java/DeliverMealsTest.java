import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalTime;

public class DeliverMealsTest {

    private CPPFoodDeliveryPlatform platform;
    private DeliverMeals deliverMeals;
    private Restaurant restaurant;
    private Driver driver;
    private Customer customer;
    private Meal meal;

    @BeforeEach
    public void setUp() {
        platform = new CPPFoodDeliveryPlatform();
        deliverMeals = new DeliverMeals();
        restaurant = new Restaurant("Test Restaurant", "123 Main St", "Test County", LocalTime.of(8, 0), LocalTime.of(22, 0), "Test Cuisine", platform);
        platform.registerRestaurant(restaurant);
        driver = new Driver("Test Driver", "456 Elm St", "Test County", LocalTime.of(8, 0), LocalTime.of(16, 0), platform);
        platform.registerDriver(driver);
        customer = new Customer("Test Customer", "789 Pine St", "Test County", platform);
        platform.registerCustomer(customer);
        meal = new Meal();
        meal.addComponent(new Macronutrient("Carb"));
        meal.addComponent(new Macronutrient("Protein"));
        meal.addComponent(new Macronutrient("Fat"));
        platform.setCurrentMeal(meal);
    }

    @Test
    public void testDeliverMeals_Success() {
        platform.setOrderTime(LocalTime.of(10, 0));
        platform.setPickUpTime(LocalTime.of(10, 30));
        platform.setSelectedRestaurantName(restaurant.getName());
        platform.setSelectedDriverName(driver.getName());
        platform.setSelectedCustomerName(customer.getName());
        platform.setDietaryRestrictions("None");
        platform.setTopping("Cheese");

        deliverMeals.deliverMeals(platform);

        assertNotNull(platform.getDeliveryTime());
    }


}
