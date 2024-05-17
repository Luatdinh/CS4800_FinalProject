public class SelectDietaryAndTopping implements OrderState {
    @Override
    public void selectDietaryAndTopping(CPPFoodDeliveryPlatform context) {
        System.out.print("Customer has selected " + context.getDietaryRestrictions() + " as dietary restriction");
        System.out.println(" along with " + context.getTopping() + " as a topping");
        context.setState(new PrepareMeals());
    }

    @Override
    public void prepareMeals(CPPFoodDeliveryPlatform context) {
        // Not applicable for this state
    }

    public void pickUpMeals(CPPFoodDeliveryPlatform context){
        // Not applicable for this state
    }
    @Override
    public void deliverMeals(CPPFoodDeliveryPlatform context) {
        // Not applicable for this state
    }
}
