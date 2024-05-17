import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;

public class CPPFoodDeliveryPlatform {
    private List<Restaurant> restaurants;
    private List<Driver> drivers;
    private List<Customer> customers;
    private LocalTime orderTime;
    private LocalTime pickUpTime; // Add this variable to store pickup time
    private LocalTime deliveryTime; // Add this variable to store delivery time
    private OrderState state;  // Added to manage the state
    private String dietaryRestrictions;
    private String topping;
    private String selectedDriverName; // Added to store the name of the selected driver
    private String selectedCustomerName; // Added to store the name of the selected customer
    private Meal currentMeal;  // Reference to the current meal being processed
    private String selectedRestaurantName; // Added to store the name of the selected restaurant
    private Customer currentCustomer; // Added to store the current customer
    private Driver currentDriver; // Added to store the current driver



    // Constructor to initialize lists for restaurants, drivers, and customers
    public CPPFoodDeliveryPlatform() {
        restaurants = new ArrayList<>();
        drivers = new ArrayList<>();
        customers = new ArrayList<>();
        this.state = new SelectDietaryAndTopping();
    }

    // Getter for the list of restaurants
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    // Getter for the list of drivers
    public List<Driver> getDrivers() {
        return drivers;
    }

    // Getter for the list of customers
    public List<Customer> getCustomers() {
        return customers;
    }

    // Getter for the order time
    public LocalTime getOrderTime() {
        return orderTime;
    }

    // Setter for the order time
    public void setOrderTime(LocalTime orderTime) {
        this.orderTime = orderTime;
    }

    // Getter for the pick up time
    public LocalTime getPickUpTime() {
        return pickUpTime;
    }

    // Setter for the pick up time
    public void setPickUpTime(LocalTime pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    // Setter for the selected driver name
    public void setSelectedDriverName(String selectedDriverName) {
        this.selectedDriverName = selectedDriverName;
    }

    // Getter for the selected driver name
    public String getSelectedDriverName() {
        return selectedDriverName;
    }

    // Getter for the selected driver
    public Driver getSelectedDriver() {
        for (Driver driver : drivers) {
            if (driver.getName().equalsIgnoreCase(selectedDriverName)) {
                return driver;
            }
        }
        return null; // Return null if no matching driver is found
    }

    // Getter for the delivery time
    public LocalTime getDeliveryTime() {
        return deliveryTime;
    }

    // Setter for the delivery time
    public void setDeliveryTime(LocalTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    // Getter and setter for the current customer
    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

    // Getter and setter for the current driver
    public Driver getCurrentDriver() {
        return currentDriver;
    }

    public void setCurrentDriver(Driver currentDriver) {
        this.currentDriver = currentDriver;
    }

    // Getter and setter for selected customer name
    public String getSelectedCustomerName() {
        return selectedCustomerName;
    }

    public void setSelectedCustomerName(String selectedCustomerName) {
        this.selectedCustomerName = selectedCustomerName;
    }

    // Method to register a restaurant on the platform
    public void registerRestaurant(Restaurant restaurant) {
        if (restaurant != null && !restaurants.contains(restaurant)) {
            restaurants.add(restaurant);
            System.out.println("Restaurant registered: " + restaurant.getName());
        } else {
            System.out.println("Failed to register restaurant: Restaurant already registered or null.");
        }
    }

    public void setCurrentMeal(Meal meal) {
        this.currentMeal = meal;
    }

    public Meal getCurrentMeal() {
        return currentMeal;
    }

    // Method to register a driver on the platform
    public void registerDriver(Driver driver) {
        if (driver != null && !drivers.contains(driver)) {
            drivers.add(driver);
            System.out.println("Driver registered: " + driver.getName());
        } else {
            System.out.println("Failed to register driver: Driver already registered or null.");
        }
    }

    // Method to register a customer on the platform
    public void registerCustomer(Customer customer) {
        if (customer != null && !customers.contains(customer)) {
            customers.add(customer);
            System.out.println("Customer registered: " + customer.getName());
        } else {
            System.out.println("Failed to register customer: Customer already registered or null.");
        }
    }

    // State management methods
    public void setState(OrderState newState) {
        this.state = newState;
    }

    // Method to process the selection of dietary and topping options
    // public void processSelectDietaryAndTopping(String dietaryRestrictions, String topping, LocalTime orderTime) {
    //     setDietaryRestrictions(dietaryRestrictions);
    //     setTopping(topping);
    //     if (state != null) {
    //         state.selectDietaryAndTopping(this);
    //     } else {
    //         System.out.println("No state is set to process dietary and topping selections.");
    //     }
    // }

    // Method to process the selection of dietary and topping options
    public void processSelectDietaryAndTopping(String dietaryRestrictions, String topping, LocalTime orderTime, String selectedRestaurantName, String selectedCustomerName) {
        setDietaryRestrictions(dietaryRestrictions);
        setTopping(topping);
        setOrderTime(orderTime);
        setSelectedRestaurantName(selectedRestaurantName);
        setSelectedCustomerName(selectedCustomerName);
        if (state != null) {
            state.selectDietaryAndTopping(this);
        } else {
            System.out.println("No state is set to process dietary and topping selections.");
        }
    }

    // Method to process the preparation of meals
    public void processPrepareMeals() {
        if (state != null) {
            state.prepareMeals(this);
        } else {
            System.out.println("No state is set to process meal preparation.");
        }
    }

    public void processPickUpMeals(String selectedDriverName) {
        setSelectedDriverName(selectedDriverName);
        if(state != null){
            state.pickUpMeals(this);
        }
        else{
            System.out.println("No state is set to process meal picking up");
        }
    }


    // Method to process the delivery of meals
    public void processDeliverMeals() {
        if (state != null) {
            state.deliverMeals(this);
        } else {
            System.out.println("No state is set to process meal delivery.");
        }
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public String getTopping(){
        return topping;
    }
    public void setDietaryRestrictions(String dietaryRestrictions) {
        this.dietaryRestrictions = dietaryRestrictions;
    }

    public String getDietaryRestrictions() {
        return dietaryRestrictions;
    }

    public String getSelectedRestaurantName() {
        return selectedRestaurantName;
    }

    public void setSelectedRestaurantName(String selectedRestaurantName) {
        this.selectedRestaurantName = selectedRestaurantName;
    }

    // Method to get the selected restaurant by name
    public Restaurant getSelectedRestaurant() {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getName().equalsIgnoreCase(selectedRestaurantName)) {
                return restaurant;
            }
        }
        return null; // Return null if no matching restaurant is found
    }

}
