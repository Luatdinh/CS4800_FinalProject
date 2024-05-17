import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

public class CustomerTest {

    private CPPFoodDeliveryPlatform platform;
    private Customer customer;

    @BeforeEach
    public void setUp() {
        platform = new CPPFoodDeliveryPlatform();
        customer = new Customer("Customer1", "100 First St", "LA County", platform);
    }

    @Test
    public void testCustomerInitialization() {
        assertEquals("Customer1", customer.getName());
        assertEquals("100 First St", customer.getAddress());
        assertEquals("LA County", customer.getCounty());
    }

    @Test
    public void testSetName() {
        customer.setName("New Customer");
        assertEquals("New Customer", customer.getName());
    }

    @Test
    public void testSetAddress() {
        customer.setAddress("200 Second St");
        assertEquals("200 Second St", customer.getAddress());
    }

    @Test
    public void testSetCounty() {
        customer.setCounty("Orange County");
        assertEquals("Orange County", customer.getCounty());
    }

    @Test
    public void testSelectDietaryAndTopping() {
        LocalTime orderTime = LocalTime.of(10, 0);
        customer.selectDietaryAndTopping("Vegan", "Tomato", orderTime, "The Green Bowl");

        assertEquals("Vegan", platform.getDietaryRestrictions());
        assertEquals("Tomato", platform.getTopping());
        assertEquals(orderTime, platform.getOrderTime());
        assertEquals("The Green Bowl", platform.getSelectedRestaurantName());
        assertEquals("Customer1", platform.getSelectedCustomerName());
    }
}
