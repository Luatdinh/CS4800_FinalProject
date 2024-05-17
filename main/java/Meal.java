import java.util.ArrayList;
import java.util.List;

public class Meal {

    private List<Object> components;

    public Meal() {
        this.components = new ArrayList<>();
    }

    public void addComponent(Object component) {
        components.add(component);
    }

    public void displayComponents() {
        for (Object component : components) {
            if (component instanceof Protein) {
                ((Protein) component).eat();
            } else if (component instanceof Carb) {
                ((Carb) component).eat();
            } else if (component instanceof Fat) {
                ((Fat) component).eat();
            }
        }
    }
}
