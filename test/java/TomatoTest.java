import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TomatoTest {

    @Test
    public void testDescribeTopping() {
        Tomato tomato = new Tomato();
        assertEquals("Tomato", tomato.describeTopping());
    }
}