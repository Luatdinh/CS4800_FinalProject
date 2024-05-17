import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ChickenTest {

    private Chicken chicken;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        chicken = new Chicken();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testEat() {
        chicken.eat();
        assertEquals("- Chicken.\n", outContent.toString());
    }

    @org.junit.jupiter.api.AfterEach
    public void restoreSystemOut() {
        System.setOut(originalOut);
    }
}
