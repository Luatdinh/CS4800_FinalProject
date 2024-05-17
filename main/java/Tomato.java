public class Tomato implements FoodItem {
    private String description;

    public Tomato() {
        this.description = "Tomato";
    }

    @Override
    public String describeTopping() {
        return this.description;
    }
}