
public class Macronutrient implements MacronutrientFactory {
    private String dietPlan;

    public Macronutrient(String dietPlan) {
        this.dietPlan = dietPlan;
    }

    @Override
    public Carb createCarb() {
        return CarbFactory.getInstance().getCarb(dietPlan);
    }

    @Override
    public Protein createProtein() {
        return ProteinFactory.getInstance().getProtein(dietPlan);
    }

    @Override
    public Fat createFat() {
        return FatFactory.getInstance().getFat(dietPlan);
    }
}