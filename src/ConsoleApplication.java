import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * A console application class to demonstrate car and home quotes
 * @SAR_Solutions
 */
public class ConsoleApplication {
    public static Client client;
    public static Vehicle vehicle;
    public static Home home;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userChoice = -1;

        do {
            System.out.println("------ Welcome to Taylor's Insurance ------");
            System.out.println("Please make a choice");
            System.out.println("[1] - Quote for a home");
            System.out.println("[2] - Quote for a Car");
            System.out.println("[3] - Quote for both Car and home");
            System.out.println("[0] - Exit");
            userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1 -> {
                    client = createClient();
                    home = createHome();
                    displayClientInfo(client);
                    displayHomeQuote(home);
                    break;
                }
                case 2 -> {
                    client = createClient();
                    vehicle = createCar();
                    displayClientInfo(client);
                    displayCarQuote(vehicle);
                    break;
                }
                case 3 -> {
                    client = createClient();
                    home = createHome();
                    vehicle = createCar();
                    displayClientInfo(client);
                    displayHomeQuote(home);
                    displayCarQuote(vehicle);
                    break;
                }
                case 0 -> {System.out.println("All done! - Thank you!");
                    System.exit(0);
                }
            }
        }
        while (userChoice != 0);
    }

    public static Client createClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Client's first name");
        String clientFname = scanner.next();
        System.out.println();
        System.out.println("Enter Client's last name");
        String clientLname = scanner.next();
        System.out.println();
        System.out.println("Enter Client's DoB");
        System.out.println("Year: (YYYY)");
        int year = scanner.nextInt();
        System.out.println("Month: (MM)");
        int month = scanner.nextInt();
        System.out.println("Day: (DD)");
        int day = scanner.nextInt();

        return new Client(clientFname, clientLname, LocalDate.of(year, month, day));
    }

    public static Vehicle createCar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Car Make:");
        String make = scanner.next();
        System.out.println("Enter Car Model");
        String model = scanner.next();
        System.out.println("Enter Car Year");
        int year = scanner.nextInt();
        System.out.println("How many accidents this car have had within past 5 years?");
        int accidents = scanner.nextInt();

        return new Vehicle(client, make, model, LocalDate.of(year, 06,01), accidents);
    }

    public static Home createHome() {
        Home.HeatingType selectedHeatingType;
        Home.LocationType selectedLocationType;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Home Value (CAD):");
        double homeValue = scanner.nextDouble();
        System.out.println("Enter year built: ");
        int year = scanner.nextInt();
        System.out.println("Enter Street Number: ");
        String home_street_number = scanner.next();
        System.out.println("Enter Street Name: ");
        String home_street_name = scanner.next();
        System.out.println("Enter City: ");
        String home_city = scanner.next();
        System.out.println("Enter Postalcode: ");
        String postalcode = scanner.next();
        System.out.println("Select Heating type (only numbers 1 - 3):");
        System.out.println("\t[1] - OIL_HEATING");
        System.out.println("\t[2] - WOOD_HEATING");
        System.out.println("\t[3] - OTHER_HEATING");
        int heatingType = scanner.nextInt();
        switch (heatingType) {
            case 1 -> {
                selectedHeatingType = Home.HeatingType.OIL_HEATING;
                break;
            }
            case 2 -> {
                selectedHeatingType = Home.HeatingType.WOOD_HEATING;
                break;
            }
            default ->
                selectedHeatingType = Home.HeatingType.OTHER_HEATING;
        }
        System.out.println("Select Location Type (only numbers 1-2):");
        System.out.println("\t[1] - Urban");
        System.out.println("\t[2] - Rural");
        int locationType = scanner.nextInt();
        switch (locationType) {
            case 1 -> {
                selectedLocationType = Home.LocationType.RURAL_LOCATION;
                break;
            }
            default ->
                selectedLocationType = Home.LocationType.URBAN_LOCATION;
        }

        return new Home(client, homeValue,
                LocalDate.of(year, 06,01),
                selectedHeatingType, selectedLocationType,
               home_street_number, home_street_name,
                home_city, postalcode);
    }

    /**
     * Get the user inputs, store and display a home quote object
     * @param home
     */
    private static void displayHomeQuote(Home home){
        HomeQuote homeQuote = QuoteManager.getNewHomeQuote(home);
        BigDecimal homeBasePremium = QuoteManager.getHomeQuotePremium(home).setScale(2, RoundingMode.HALF_UP);
        System.out.println("Home Address: " + homeQuote.getQuotedHome().getHomeStreetNumber() +
                " " + homeQuote.getQuotedHome().getHomeStreetName() + ", " + homeQuote.getQuotedHome().getHomeAddressCity());
        System.out.println("Home PostalCode: " + homeQuote.getQuotedHome().getHomePostalCode());
        System.out.println("Home Location type: " + homeQuote.getQuotedHome().getLocationType());
        System.out.println("Home Heating type: " + homeQuote.getQuotedHome().getHeatingType());
        System.out.println("Home Age: " + homeQuote.getQuotedHome().getHomeAge() + " years old");
        System.out.println("Home Value (CAD): " + homeQuote.getQuotedHome().getHomeValue());
        System.out.println("---------------------------------------------");
        System.out.println("Premium before tax: \t\t" + homeBasePremium + " CAD");
        System.out.println("---------------------------------------------");
        System.out.println("Premium before tax: \t\t" +
                QuoteManager.getPremiumAfterTax(homeBasePremium).setScale(2, RoundingMode.HALF_UP) + " CAD");
        System.out.println("=============================================\n\n");
    }

    /**
     * Get the user inputs, store and display a car quote object
     * @param vehicle
     */
    private static void displayCarQuote(Vehicle vehicle){
        VehicleQuote vehicleQuote = QuoteManager.getNewCarQuote(vehicle);
        BigDecimal carBasePremium = QuoteManager.getCarQuotePremium(vehicle).setScale(2, RoundingMode.HALF_UP);
        System.out.println("Car Make: " + vehicleQuote.getQuotedCar().getCarMake());
        System.out.println("Car Model: " + vehicleQuote.getQuotedCar().getCarModel());
        System.out.println("Car age: " + vehicleQuote.getQuotedCar().getCar_age() + " years old");
        System.out.println("Car Accidents (Past 5 years): " +
                vehicleQuote.getQuotedCar().getNumberOfAccidents() + " times");

        System.out.println("---------------------------------------------");
        System.out.println("Car Quote Premium before tax: " + carBasePremium + " CAD");
        System.out.println("---------------------------------------------");
        System.out.println("Car Quote Premium before tax: " +
                QuoteManager.getPremiumAfterTax(carBasePremium).setScale(2, RoundingMode.HALF_UP) + " CAD");
        System.out.println("=============================================\n\n");
    }

    /**
     * Get the client info and display it
     * @param client
     */
    private static void displayClientInfo(Client client) {
        System.out.println("Client's name: " + client.getClientFName() +
                " " + client.getClientLName());
    }
}
