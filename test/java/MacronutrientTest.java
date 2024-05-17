import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MacronutrientTest {

    private Macronutrient macronutrient;

    @BeforeEach
    public void setUp() {
        macronutrient = new Macronutrient("Paleo");
    }

    @Test
    public void testCreateCarb() {
        assertTrue(macronutrient.createCarb() instanceof Carb);
    }

    @Test
    public void testCreateProtein() {
        assertTrue(macronutrient.createProtein() instanceof Protein);
    }

    @Test
    public void testCreateFat() {
        assertTrue(macronutrient.createFat() instanceof Fat);
    }
}
