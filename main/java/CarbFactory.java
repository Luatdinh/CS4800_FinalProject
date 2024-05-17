import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class CarbFactory {
    private static CarbFactory instance;
    private Random random = new Random();

    private CarbFactory() {}

    public static synchronized CarbFactory getInstance() {
        if (instance == null) {
            instance = new CarbFactory();
        }
        return instance;
    }

    public Carb getCarb(String dietPlan) {
        List<Carb> carbs = new ArrayList<>();
        switch (dietPlan) {
            case "Paleo":
                carbs.add(new Pistachio());
                break;
            case "Vegan":
                carbs.add(new Bread());
                carbs.add(new Pistachio());
                carbs.add(new Lentils());
                break;
            case "Nut Allergy":
                carbs.add(new Bread());
                carbs.add(new Cheese());
                carbs.add(new Lentils());
                break;
            default:
                carbs.add(new Bread());
                carbs.add(new Pistachio());
                carbs.add(new Lentils());
                carbs.add(new Cheese());
                break;
        }
        return carbs.get(random.nextInt(carbs.size()));

    }
}