import java.time.LocalTime;
import java.time.Duration;
import java.util.Random;

public class PrepareMeals implements OrderState {
    @Override
    public void selectDietaryAndTopping(CPPFoodDeliveryPlatform context) {
        // Not applicable for this state
    }

    @Override
    public void prepareMeals(CPPFoodDeliveryPlatform context) {

        LocalTime orderTime = context.getOrderTime();
        String selectedRestaurantName = context.getSelectedRestaurantName();

        Restaurant selectedRestaurant = null;
        for (Restaurant restaurant : context.getRestaurants()) {
            if (restaurant.getName().equalsIgnoreCase(selectedRestaurantName)) {
                selectedRestaurant = restaurant;
                break;
            }
        }

        LocalTime openingTime = selectedRestaurant.getOpeningTime();
        LocalTime closingTime = selectedRestaurant.getClosingTime();

        if (orderTime.isAfter(openingTime) && orderTime.isBefore(closingTime)) {
            System.out.println("Preparing meals based on dietary restrictions: " + context.getDietaryRestrictions());
            System.out.println("Adding the selected topping, " + context.getTopping() + ", to the meal");

            createMealForDiet(context.getDietaryRestrictions(), selectedRestaurant);

            LocalTime pickupTime = calculatePickupTime(orderTime);
            context.setPickUpTime(pickupTime);
            System.out.println("Pickup time: " + pickupTime);

            context.setCurrentMeal(selectedRestaurant.getMeals().get(selectedRestaurant.getMeals().size() - 1));
            context.setState(new PickUpMeals());
        } else {
            System.out.println("Order time is outside the restaurant's operating hours.");
            context.setState(new SelectDietaryAndTopping());
        }
    }

    private void createMealForDiet(String dietaryRestriction, Restaurant restaurant) {
        Macronutrient macronutrient = new Macronutrient(dietaryRestriction);
        Meal meal = new Meal();
        meal.addComponent(macronutrient.createCarb());
        meal.addComponent(macronutrient.createProtein());
        meal.addComponent(macronutrient.createFat());
        restaurant.getMeals().add(meal);
    }

    private LocalTime calculatePickupTime(LocalTime orderTime) {
        Random random = new Random();
        int preparationTimeMinutes = 15 + random.nextInt(31);
        return orderTime.plus(Duration.ofMinutes(preparationTimeMinutes));
    }

    @Override
    public void pickUpMeals(CPPFoodDeliveryPlatform context) {
        // Not applicable for this state
    }

    @Override
    public void deliverMeals(CPPFoodDeliveryPlatform context) {
        // Not applicable for this state
    }
}

