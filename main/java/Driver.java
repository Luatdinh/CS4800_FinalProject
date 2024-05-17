import java.time.LocalTime;
public class Driver {
    private String name;
    private String address;
    private String operatingCounty;
    private OrderState currentState;
    private LocalTime shiftStart;
    private LocalTime shiftEnd;

    private CPPFoodDeliveryPlatform server;

    public Driver(String name, String address, String operatingCounty, LocalTime shiftStart, LocalTime shiftEnd, CPPFoodDeliveryPlatform server) {
        this.name = name;
        this.address = address;
        this.operatingCounty = operatingCounty;
        this.currentState = null;
        this.shiftStart = shiftStart;
        this.shiftEnd = shiftEnd;
        this.server = server;
    }


    public LocalTime getShiftStart() {
        return shiftStart;
    }

    public void setShiftStart(LocalTime shiftStart) {
        this.shiftStart = shiftStart;
    }

    public LocalTime getShiftEnd() {
        return shiftEnd;
    }

    public void setShiftEnd(LocalTime shiftEnd) {
        this.shiftEnd = shiftEnd;
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

    public String getOperatingCounty() {
        return operatingCounty;
    }

    public void setOperatingCounty(String operatingCounty) {
        this.operatingCounty = operatingCounty;
    }

    public OrderState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(OrderState state) {
        this.currentState = state;
        if (state != null) {
            System.out.println("Driver " + name + " state updated to: " + state.getClass().getSimpleName());
        }
    }

    public void deliver() {
        server.processDeliverMeals();

    }

    public void pickUpMeal(){
        server.processPickUpMeals(getName());
    }

}
