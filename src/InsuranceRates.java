/**
 * An interface for insurance rates. This allows for rates to be abstracted to web service.
 * This is a single set of rates for both home and car.
 * @Author SAR_Solutions
 */
public interface InsuranceRates {
    /**
     * Get the base premium for the home quote
     * @return base premium
     */
    public double getHomeBasePremium();

    /**
     * Get the rating factor for heating type
     * @param heatingType factor
     * @return
     */
    public double getHeatingTypeFactor(Home.HeatingType heatingType);

    /**
     * Get the rating factor for location type
     * @param locationType factor
     * @return
     */
    public double getLocationTypeFactor(Home.LocationType locationType);

    /**
     * Get the home age factor
     * @param yearsOld
     * @return home age factor
     */
    public double getHomeAgeFactor(int yearsOld);

    /**
     * Get the car base premium
     * @return base premium
     */
    public double getCarBasePremium();

    /**
     * Get the car age factor
     * @param yearsOld
     * @return
     */
    public double getCarAgeFactor(int yearsOld);

    /**
     * Get the driver age factor
     * @param yearsOld
     * @return
     */
    public double getDriverAgeFactor(int yearsOld);

    /**
     * Get the number of accidents
     * @param numberOfAccidents
     * @return
     */
    public double getHadAccident(int numberOfAccidents);

    public double getTaxRate();
}
