import java.util.List;
import java.util.ArrayList;
import java.util.Random;


public class ProteinFactory {
    private static ProteinFactory instance;
    private Random random = new Random();

    private ProteinFactory() {}

    public static synchronized ProteinFactory getInstance() {
        if (instance == null) {
            instance = new ProteinFactory();
        }
        return instance;
    }

    public Protein getProtein(String dietPlan) {
        List<Protein> proteins = new ArrayList<>();

        switch (dietPlan) {
            case "Vegan":
                proteins.add(new Tofu());
                break;
            case "Paleo":
                proteins.add(new Chicken());
                proteins.add(new Fish());
                proteins.add(new Beef());
                break;
            case "Nut Allergy":
                proteins.add(new Chicken());
                proteins.add(new Fish());
                proteins.add(new Beef());
                proteins.add(new Tofu());
                break;
            default:
                proteins.add(new Chicken());
                proteins.add(new Fish());
                proteins.add(new Beef());
                proteins.add(new Tofu());
                break;
        }

        return proteins.get(random.nextInt(proteins.size()));
    }
}