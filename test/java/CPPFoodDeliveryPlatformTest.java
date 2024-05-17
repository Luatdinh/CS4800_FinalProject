import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalTime;

public class CPPFoodDeliveryPlatformTest {

    private CPPFoodDeliveryPlatform platform;
    private Restaurant veganRestaurant;
    private Driver driver1;
    private Customer customer1;

    @BeforeEach
    public void setUp() {
        platform = new CPPFoodDeliveryPlatform();
        veganRestaurant = new Restaurant("The Green Bowl", "123 Veggie Road", "LA County", LocalTime.of(8, 0), LocalTime.of(22, 0), "Vegan", platform);
        platform.registerRestaurant(veganRestaurant);
        driver1 = new Driver("Driver1", "Main Street 1", "LA County", LocalTime.of(8, 0), LocalTime.of(16, 0), platform);
        platform.registerDriver(driver1);
        customer1 = new Customer("Customer1", "100 First St", "LA County", platform);
        platform.registerCustomer(customer1);
    }

    @Test
    public void testRegisterRestaurant() {
        assertEquals(1, platform.getRestaurants().size());
        assertEquals("The Green Bowl", platform.getRestaurants().get(0).getName());
    }

    @Test
    public void testRegisterDriver() {
        assertEquals(1, platform.getDrivers().size());
        assertEquals("Driver1", platform.getDrivers().get(0).getName());
    }

    @Test
    public void testRegisterCustomer() {
        assertEquals(1, platform.getCustomers().size());
        assertEquals("Customer1", platform.getCustomers().get(0).getName());
    }

    @Test
    public void testSelectDietaryAndTopping() {
        LocalTime orderTime = LocalTime.of(10, 0);
        platform.processSelectDietaryAndTopping("Vegan", "Tomato", orderTime, "The Green Bowl", "Customer1");
        assertEquals("Vegan", platform.getDietaryRestrictions());
        assertEquals("Tomato", platform.getTopping());
        assertEquals(orderTime, platform.getOrderTime());
        assertEquals("The Green Bowl", platform.getSelectedRestaurantName());
        assertEquals("Customer1", platform.getSelectedCustomerName());
    }

    @Test
    public void testPrepareMeals() {
        LocalTime orderTime = LocalTime.of(10, 0);
        platform.processSelectDietaryAndTopping("Vegan", "Tomato", orderTime, "The Green Bowl", "Customer1");
        veganRestaurant.prepareMeal();
        assertNotNull(platform.getCurrentMeal());
    }

    @Test
    public void testPickUpMeals() {
        LocalTime orderTime = LocalTime.of(10, 0);
        platform.processSelectDietaryAndTopping("Vegan", "Tomato", orderTime, "The Green Bowl", "Customer1");
        platform.setCurrentDriver(driver1);
        platform.setCurrentCustomer(customer1);
        veganRestaurant.prepareMeal();
        driver1.pickUpMeal();
        assertNotNull(platform.getPickUpTime());
    }

    @Test
    public void testDeliverMeals() {
        LocalTime orderTime = LocalTime.of(10, 0);
        platform.processSelectDietaryAndTopping("Vegan", "Tomato", orderTime, "The Green Bowl", "Customer1");
        platform.setCurrentDriver(driver1);
        platform.setCurrentCustomer(customer1);
        veganRestaurant.prepareMeal();
        driver1.pickUpMeal();
        driver1.deliver();
        assertNotNull(platform.getDeliveryTime());
    }
}
