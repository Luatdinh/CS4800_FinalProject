import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SourCreamTest {

    private SourCream sourCream;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        sourCream = new SourCream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testEat() {
        sourCream.eat();
        assertEquals("- Sour Cream.\n", outContent.toString());
    }

    @org.junit.jupiter.api.AfterEach
    public void restoreSystemOut() {
        System.setOut(originalOut);
    }
}
