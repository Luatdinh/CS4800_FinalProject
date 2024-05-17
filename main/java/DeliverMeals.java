import java.time.LocalTime;
import java.time.Duration;
import java.util.Random;

public class DeliverMeals implements OrderState {
    @Override
    public void selectDietaryAndTopping(CPPFoodDeliveryPlatform context) {
        // Not applicable for this state
    }

    @Override
    public void prepareMeals(CPPFoodDeliveryPlatform context) {
        // Not applicable for this state
    }

    @Override
    public void pickUpMeals(CPPFoodDeliveryPlatform context) {
        // Not applicable for this state
    }

    @Override
    public void deliverMeals(CPPFoodDeliveryPlatform context) {
        Meal meal = context.getCurrentMeal();
        String toppingDescription = context.getTopping();
        Restaurant restaurant = context.getSelectedRestaurant();
        LocalTime orderTime = context.getOrderTime();
        LocalTime pickupTime = context.getPickUpTime();
        LocalTime deliveryTime = calculateDeliveryTime(pickupTime);
        context.setDeliveryTime(deliveryTime);

        System.out.println("\nORDER DETAILS:");
        System.out.println("Restaurant: " + context.getSelectedRestaurantName());
        System.out.println("Customer: " + context.getSelectedCustomerName());
        System.out.println("Dietary Restriction: " + context.getDietaryRestrictions());

        meal.displayComponents();
        displayDecoratedMeal(toppingDescription, restaurant.getMenu());
        System.out.println("Driver: " + context.getSelectedDriverName());
        System.out.println("Order Creation Time: " + orderTime);
        System.out.println("Order Pickup Time: " + pickupTime);
        System.out.println("Order Delivery Time: " + deliveryTime);
        System.out.println("Meal delivered.");

        context.setState(new SelectDietaryAndTopping());
    }

    private void displayDecoratedMeal(String toppingDescription, Menu menu) {
        FoodItem topping = menu.getToppingByDescription(toppingDescription);
        if (topping != null) {
            System.out.println("With Topping: " + topping.describeTopping());
        } else {
            System.out.println("No toppings applied.");
        }
    }

    private LocalTime calculateDeliveryTime(LocalTime pickupTime) {
        Random random = new Random();
        int deliveryDurationMinutes = 10 + random.nextInt(21); // Random time between 10 and 30 minutes
        return pickupTime.plus(Duration.ofMinutes(deliveryDurationMinutes));
    }
}
