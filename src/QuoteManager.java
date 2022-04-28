import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Generates quotes
 * @Author SAR_Solutions
 */
public class QuoteManager {

    /**
     * Get a new home quote
     * @param home
     * @return
     */
    public static HomeQuote getNewHomeQuote(Home home){
        return new HomeQuote(LocalDate.now(),LocalDate.now().plusDays(30), home);
    }

    /**
     * Get the home quote premium
     * @param home
     * @return
     */
    public static BigDecimal getHomeQuotePremium(Home home){
        InsuranceRates insuranceRates = new HardCodedRates();
        BigDecimal bigDecimal = new BigDecimal(insuranceRates.getHomeBasePremium());
        bigDecimal = bigDecimal.multiply(BigDecimal.valueOf(insuranceRates.getHeatingTypeFactor(home.getHeatingType())));
        bigDecimal = bigDecimal.multiply(BigDecimal.valueOf(insuranceRates.getLocationTypeFactor(home.getLocationType())));
        bigDecimal = bigDecimal.multiply(BigDecimal.valueOf(insuranceRates.getHomeAgeFactor(home.getHomeAge())));
        return bigDecimal;
    }

    /**
     * Get a new car quote
     * @param vehicle
     * @return
     */
    public static VehicleQuote getNewCarQuote (Vehicle vehicle) {
        return new VehicleQuote(LocalDate.now(), LocalDate.now().plusDays(30), vehicle);
    }

    /**
     * Get the car quote premium
     * @param vehicle
     * @return
     */
    public static BigDecimal getCarQuotePremium (Vehicle vehicle) {
        InsuranceRates insuranceRates = new HardCodedRates();
        BigDecimal bigDecimal = new BigDecimal(insuranceRates.getCarBasePremium());
        bigDecimal = bigDecimal.multiply(BigDecimal.valueOf(insuranceRates.getCarAgeFactor(vehicle.getCar_age())));
        bigDecimal = bigDecimal.multiply(BigDecimal.valueOf(insuranceRates.getDriverAgeFactor(vehicle.getClient().getClient_age())));
        bigDecimal = bigDecimal.multiply(BigDecimal.valueOf(insuranceRates.getHadAccident(vehicle.getNumberOfAccidents())));

        return bigDecimal;
    }

    /**
     * Calculates tax based on the amount of the premium
     * @return premium after tax
     */
    public static BigDecimal getPremiumAfterTax(BigDecimal bigDecimal) {
        InsuranceRates insuranceRates = new HardCodedRates();
        return bigDecimal.multiply(BigDecimal.valueOf(insuranceRates.getTaxRate()));
    }
}
