import java.time.LocalTime;

public class Customer {
    private String name;
    private String address;
    private String county;
    private LocalTime orderTime;
    private CPPFoodDeliveryPlatform server;

    public Customer(String name, String address, String county, CPPFoodDeliveryPlatform server) {
        this.name = name;
        this.address = address;
        this.county = county;
        this.server = server;
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

    public void selectDietaryAndTopping(String dietaryRestrictions, String topping, LocalTime orderTime, String selectedRestaurantName) {
        server.processSelectDietaryAndTopping(dietaryRestrictions, topping, orderTime, selectedRestaurantName, getName());
    }


}
