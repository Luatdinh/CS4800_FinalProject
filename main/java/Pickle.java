public class Pickle implements FoodItem {
    private String description;

    public Pickle() {
        this.description = "Pickle";
    }

    @Override
    public String describeTopping() {
        return this.description;
    }
}