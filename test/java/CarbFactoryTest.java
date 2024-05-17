import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarbFactoryTest {

    private CarbFactory carbFactory;

    @BeforeEach
    public void setUp() {
        carbFactory = CarbFactory.getInstance();
    }

    @Test
    public void testGetInstance() {
        assertNotNull(CarbFactory.getInstance());
        assertEquals(carbFactory, CarbFactory.getInstance());
    }

    @Test
    public void testGetCarb() {
        assertTrue(carbFactory.getCarb("Paleo") instanceof Carb);
        assertTrue(carbFactory.getCarb("Vegan") instanceof Carb);
        assertTrue(carbFactory.getCarb("Nut Allergy") instanceof Carb);
        assertTrue(carbFactory.getCarb("Unknown") instanceof Carb);
    }
}
