import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FatFactoryTest {

    private FatFactory fatFactory;

    @BeforeEach
    public void setUp() {
        fatFactory = FatFactory.getInstance();
    }

    @Test
    public void testGetInstance() {
        assertNotNull(FatFactory.getInstance());
        assertEquals(fatFactory, FatFactory.getInstance());
    }

    @Test
    public void testGetFat() {
        assertTrue(fatFactory.getFat("Vegan") instanceof Fat);
        assertTrue(fatFactory.getFat("Paleo") instanceof Fat);
        assertTrue(fatFactory.getFat("Nut Allergy") instanceof Fat);
        assertTrue(fatFactory.getFat("Unknown") instanceof Fat);
    }
}
