import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalTime;

public class DriverTest {

    private CPPFoodDeliveryPlatform platform;
    private Driver driver;

    @BeforeEach
    public void setUp() {
        platform = new CPPFoodDeliveryPlatform();
        driver = new Driver("Driver1", "123 Main St", "LA County", LocalTime.of(8, 0), LocalTime.of(16, 0), platform);
    }

    @Test
    public void testDriverInitialization() {
        assertEquals("Driver1", driver.getName());
        assertEquals("123 Main St", driver.getAddress());
        assertEquals("LA County", driver.getOperatingCounty());
        assertEquals(LocalTime.of(8, 0), driver.getShiftStart());
        assertEquals(LocalTime.of(16, 0), driver.getShiftEnd());
    }

    @Test
    public void testSetName() {
        driver.setName("New Driver");
        assertEquals("New Driver", driver.getName());
    }

    @Test
    public void testSetAddress() {
        driver.setAddress("456 New St");
        assertEquals("456 New St", driver.getAddress());
    }

    @Test
    public void testSetOperatingCounty() {
        driver.setOperatingCounty("Orange County");
        assertEquals("Orange County", driver.getOperatingCounty());
    }

    @Test
    public void testSetShiftStart() {
        driver.setShiftStart(LocalTime.of(7, 0));
        assertEquals(LocalTime.of(7, 0), driver.getShiftStart());
    }

    @Test
    public void testSetShiftEnd() {
        driver.setShiftEnd(LocalTime.of(17, 0));
        assertEquals(LocalTime.of(17, 0), driver.getShiftEnd());
    }

    @Test
    public void testSetCurrentState() {
        OrderState state = new SelectDietaryAndTopping();
        driver.setCurrentState(state);
        assertEquals(state, driver.getCurrentState());
    }

    @Test
    public void testPickUpMeal() {
        driver.pickUpMeal();
        assertEquals("Driver1", platform.getSelectedDriverName());
    }

    @Test
    public void testDeliver() {
        driver.deliver();
    }
}
