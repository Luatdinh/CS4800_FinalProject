public class Sauce implements FoodItem {
    private String description;

    public Sauce() {
        this.description = "Sauce";
    }

    @Override
    public String describeTopping() {
        return this.description;
    }
}