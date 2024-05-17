import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TunaTest {

    private Tuna tuna;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        tuna = new Tuna();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testEat() {
        tuna.eat();
        assertEquals("- Tuna.\n", outContent.toString());
    }

    @org.junit.jupiter.api.AfterEach
    public void restoreSystemOut() {
        System.setOut(originalOut);
    }
}
