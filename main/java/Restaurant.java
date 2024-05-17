import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;

public class Restaurant {
    private String name;
    private String address;
    private String county;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private String cuisineType;
    private List<Meal> meals;
    private Menu menu;
    private CPPFoodDeliveryPlatform server;

    public Restaurant(String name, String address, String county, LocalTime openingTime, LocalTime closingTime, String cuisineType, CPPFoodDeliveryPlatform server) {
        this.name = name;
        this.address = address;
        this.county = county;
        this.cuisineType = cuisineType;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.meals = new ArrayList<>();
        this.menu = new Menu();
        this.server = server;
        prepareDietaryMeals();
    }

    private void prepareDietaryMeals() {
        createMealForDiet("No Restriction");
        createMealForDiet("Paleo");
        createMealForDiet("Vegan");
        createMealForDiet("Nut Allergy");
    }

    public void createMealForDiet(String dietaryRestriction) {
        Macronutrient macronutrient = new Macronutrient(dietaryRestriction);
        Meal meal = new Meal();
        meal.addComponent(macronutrient.createCarb());
        meal.addComponent(macronutrient.createProtein());
        meal.addComponent(macronutrient.createFat());
        meals.add(meal);
    }

    public void prepareMeal() {
        server.processPrepareMeals();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public Menu getMenu() {
        return menu;
    }


}
