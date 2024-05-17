import java.time.LocalTime;
public class Main {
    public static void main(String[] args) {
        CPPFoodDeliveryPlatform platform = new CPPFoodDeliveryPlatform();
        Restaurant veganRestaurant = new Restaurant("The Green Bowl", "123 Veggie Road", "LA County", LocalTime.of(8, 0), LocalTime.of(22, 0), "Vegan", platform);
        Restaurant seafoodRestaurant = new Restaurant("Ocean's Catch", "234 Fish Ave", "Orange County", LocalTime.of(10, 0), LocalTime.of(20, 0), "Seafood", platform);
        Restaurant steakhouseRestaurant = new Restaurant("Steak Paradise", "345 Meat St", "Orange County", LocalTime.of(11, 0), LocalTime.of(23, 0), "Steakhouse", platform);
        Restaurant italianRestaurant = new Restaurant("Pure Pasta", "456 Italian Blvd", "San Bernardino", LocalTime.of(9, 0), LocalTime.of(21, 0), "Italian", platform);
        platform.registerRestaurant(veganRestaurant);
        platform.registerRestaurant(seafoodRestaurant);
        platform.registerRestaurant(steakhouseRestaurant);
        platform.registerRestaurant(italianRestaurant);

        Driver driver1 = new Driver("Driver1", "Main Street 1", "LA County", LocalTime.of(8, 0), LocalTime.of(16, 0), platform);
        Driver driver2 = new Driver("Driver2", "Second Street 2", "LA County", LocalTime.of(16, 0), LocalTime.of(0, 0), platform);
        Driver driver3 = new Driver("Driver3", "Third Street 3", "San Bernardino", LocalTime.of(0, 0), LocalTime.of(8, 0), platform);
        Driver driver4 = new Driver("Driver4", "Fourth Street 4", "LA County", LocalTime.of(8, 0), LocalTime.of(16, 0), platform);
        Driver driver5 = new Driver("Driver5", "Fifth Street 5", "Orange County", LocalTime.of(16, 0), LocalTime.of(0, 0), platform);
        Driver driver6 = new Driver("Driver6", "Sixth Street 6", "San Bernardino", LocalTime.of(0, 0), LocalTime.of(8, 0), platform);
        Driver driver7 = new Driver("Driver7", "Seventh Street 7", "LA County", LocalTime.of(8, 0), LocalTime.of(16, 0), platform);
        Driver driver8 = new Driver("Driver8", "Eighth Street 8", "Orange County", LocalTime.of(16, 0), LocalTime.of(0, 0), platform);
        Driver driver10 = new Driver("Driver10", "Tenth Street 10", "Orange County", LocalTime.of(16, 0), LocalTime.of(0, 0), platform);
        platform.registerDriver(driver1);
        platform.registerDriver(driver2);
        platform.registerDriver(driver3);
        platform.registerDriver(driver4);
        platform.registerDriver(driver5);
        platform.registerDriver(driver6);
        platform.registerDriver(driver7);
        platform.registerDriver(driver8);
        platform.registerDriver(driver10);

        Customer customer1 = new Customer("Customer1", "100 First St", "LA County", platform);
        Customer customer2 = new Customer("Customer2", "200 Second St", "Orange County", platform);
        Customer customer3 = new Customer("Customer3", "200 Second St", "Orange", platform);
        Customer customer4 = new Customer("Customer4", "300 Third St", "Orange County", platform);
        Customer customer5 = new Customer("Customer5", "400 Fourth St", "San Bernardino", platform);
        Customer customer6 = new Customer("Customer6", "500 Fifth St", "LA County", platform);
        Customer customer7 = new Customer("Customer7", "600 Sixth St", "San Bernardino", platform);
        Customer customer8 = new Customer("Customer8", "700 Seventh St", "", platform);
        Customer customer9 = new Customer("Customer9", "800 Eighth St", "Riverside", platform);
        Customer customer10 = new Customer("Customer10", "900 Ninth St", "Los Angeles", platform);
        platform.registerCustomer(customer1);
        platform.registerCustomer(customer2);
        platform.registerCustomer(customer3);
        platform.registerCustomer(customer4);
        platform.registerCustomer(customer5);
        platform.registerCustomer(customer6);
        platform.registerCustomer(customer7);
        platform.registerCustomer(customer8);
        platform.registerCustomer(customer9);
        platform.registerCustomer(customer10);

        System.out.println();
        System.out.println("Customer1");
        LocalTime orderTime1 = LocalTime.of(12, 0);
        customer1.selectDietaryAndTopping("Vegan", "Tomato", orderTime1, veganRestaurant.getName());
        veganRestaurant.prepareMeal();
        driver1.pickUpMeal();
        driver1.deliver();

        System.out.println();
        System.out.println("Customer2");
        LocalTime orderTime2 = LocalTime.of(9, 0);
        customer2.selectDietaryAndTopping("Vegan", "Sauce", orderTime2, veganRestaurant.getName());
        veganRestaurant.prepareMeal();
        driver2.pickUpMeal();
        driver2.deliver();

        System.out.println();
        System.out.println("Customer3");
        LocalTime orderTime3 = LocalTime.of(14, 0);
        customer3.selectDietaryAndTopping("Vegan", "Pickle", orderTime3, veganRestaurant.getName());
        veganRestaurant.prepareMeal();
        driver1.pickUpMeal();
        driver1.deliver();

        System.out.println();
        System.out.println("Customer4");
        LocalTime orderTime4 = LocalTime.of(17, 0);
        customer4.selectDietaryAndTopping("Gluten Free", "Sauce", orderTime4, italianRestaurant.getName());
        italianRestaurant.prepareMeal();
        driver1.pickUpMeal();
        driver1.deliver();

        System.out.println();
        System.out.println("Customer5");
        LocalTime orderTime5 = LocalTime.of(20, 0);
        customer5.selectDietaryAndTopping("Vegan", "Sauce", orderTime5, steakhouseRestaurant.getName());
        veganRestaurant.prepareMeal();
        driver3.pickUpMeal();
        driver3.deliver();


        System.out.println();
        System.out.println("Customer6");
        LocalTime orderTime6 = LocalTime.of(10, 0);
        customer6.selectDietaryAndTopping("No Restriction", "Pickle", orderTime6, steakhouseRestaurant.getName());
        steakhouseRestaurant.prepareMeal();
        driver1.pickUpMeal();
        driver1.deliver();

        System.out.println();
        System.out.println("Customer7");
        LocalTime orderTime7 = LocalTime.of(13, 0);
        customer7.selectDietaryAndTopping("No Restriction", "Tomato", orderTime7, seafoodRestaurant.getName());
        seafoodRestaurant.prepareMeal();
        driver1.pickUpMeal();
        driver1.deliver();

        System.out.println();
        System.out.println("Customer8");
        LocalTime orderTime8 = LocalTime.of(16, 0);
        customer8.selectDietaryAndTopping("Nut Allergy", "Sauce", orderTime8, italianRestaurant.getName());
        italianRestaurant.prepareMeal();
        driver2.pickUpMeal();
        driver2.deliver();

        System.out.println();
        System.out.println("Customer9");
        LocalTime orderTime9 = LocalTime.of(19, 0);
        customer9.selectDietaryAndTopping("Vegan", "Pickle", orderTime9, veganRestaurant.getName());
        veganRestaurant.prepareMeal();
        driver3.pickUpMeal();
        driver3.deliver();

        System.out.println();
        System.out.println("Customer10");
        LocalTime orderTime10 = LocalTime.of(22, 0);
        customer10.selectDietaryAndTopping("Nut Allergy", "Pickle", orderTime10, steakhouseRestaurant.getName());
        steakhouseRestaurant.prepareMeal();
        driver8.pickUpMeal();
        driver8.deliver();

    }
}
