import java.time.LocalTime;

public class PickUpMeals implements OrderState {
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
        if (context.getDrivers().isEmpty()) {
            System.out.println("No drivers available.");
            return;
        }

        LocalTime pickupTime = context.getPickUpTime();
        String restaurantCounty = context.getSelectedRestaurant().getCounty();
        String selectedDriverName = context.getSelectedDriverName();

        Driver selectedDriver = null;

        for (Driver driver : context.getDrivers()) {
            if (driver.getName().equalsIgnoreCase(selectedDriverName)) {
                selectedDriver = driver;
                break;
            }
        }

        if (isDriverSameCounty(selectedDriver, restaurantCounty)) {

            if (isDriverAvailable(selectedDriver, pickupTime)) {
                context.setState(new DeliverMeals());
            }
            else {
                System.out.println("Driver " + selectedDriver.getName() + " is not available at the selected time.");
                context.setState(new SelectDietaryAndTopping());
            }

        }
        else {
            System.out.println("Driver " + selectedDriver.getName() + " is not in the same county as the restaurant so the order cannot be picked up.");
            context.setState(new SelectDietaryAndTopping());
        }
    }

    @Override
    public void deliverMeals(CPPFoodDeliveryPlatform context) {
        // Not applicable for this state
    }

    private boolean isDriverAvailable(Driver driver, LocalTime pickupTime) {
        return pickupTime.isAfter(driver.getShiftStart()) &&
                pickupTime.isBefore(driver.getShiftEnd());
    }

    private boolean isDriverSameCounty(Driver driver, String restaurantCounty) {
        return driver.getOperatingCounty().equalsIgnoreCase(restaurantCounty);
    }
}
