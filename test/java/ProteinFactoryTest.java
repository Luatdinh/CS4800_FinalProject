import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProteinFactoryTest {

    private ProteinFactory proteinFactory;

    @BeforeEach
    public void setUp() {
        proteinFactory = ProteinFactory.getInstance();
    }

    @Test
    public void testGetInstance() {
        assertNotNull(ProteinFactory.getInstance());
        assertEquals(proteinFactory, ProteinFactory.getInstance());
    }

    @Test
    public void testGetProtein() {
        assertTrue(proteinFactory.getProtein("Vegan") instanceof Protein);
        assertTrue(proteinFactory.getProtein("Paleo") instanceof Protein);
        assertTrue(proteinFactory.getProtein("Nut Allergy") instanceof Protein);
        assertTrue(proteinFactory.getProtein("Unknown") instanceof Protein);
    }
}
