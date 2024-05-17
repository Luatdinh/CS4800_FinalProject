import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SauceTest {

    @Test
    public void testDescribeTopping() {
        Sauce sauce = new Sauce();
        assertEquals("Sauce", sauce.describeTopping());
    }
}