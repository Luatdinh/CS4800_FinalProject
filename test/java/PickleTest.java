import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PickleTest {

    @Test
    public void testDescribeTopping() {
        Pickle pickle = new Pickle();
        assertEquals("Pickle", pickle.describeTopping());
    }
}