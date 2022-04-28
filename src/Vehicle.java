import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Car object fo Taylor's insurance
 * @Author SAR_Solutions
 */
public class Vehicle {
    final private static AtomicInteger count = new AtomicInteger(2000);
    private Client client;
    private String carMake;
    private String carModel;
    private LocalDate carYear;
    private int numberOfAccidents;

    /**
     * Create a new car object
     * @param client
     * @param carMake
     * @param carModel
     * @param carYear
     * @param numberOfAccidents
     */
    public Vehicle(Client client, String carMake, String carModel, LocalDate carYear, int numberOfAccidents) {
        this.client = client;
        this.carMake = carMake;
        this.carModel = carModel;
        this.carYear = carYear;
        this.numberOfAccidents = numberOfAccidents;

    }

    public Client getClient() {return client;}

    public void setClient(Client client) {this.client = client;}

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public LocalDate getCarYear() {
        return carYear;
    }

    public void setCarYear(LocalDate carYear) {
        this.carYear = carYear;
    }

    public int getNumberOfAccidents() {
        return numberOfAccidents;
    }

    public void setNumberOfAccidents(int numberOfAccidents) {
        this.numberOfAccidents = numberOfAccidents;
    }

    /**
     * Calculate car age
     * @return car age
     */
    public int getCar_age() {
        if ((this.carYear != null) && (LocalDate.now() != null)){
            return Period.between(this.carYear, LocalDate.now()).getYears();
        }else{
            return 0;
        }
    }
}
