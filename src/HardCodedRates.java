/**
 * Testing insurance rate class which will be abstracted by a web service.
 * @Author SAR_Solutions
 */
public class HardCodedRates implements InsuranceRates{
    @Override
    public double getHomeBasePremium() {
        return 500.00;
    }

    /**
     * Overrides home heating type and sets the heating type rate
     * @param heatingType factor
     * @return
     */
    @Override
    public double getHeatingTypeFactor(Home.HeatingType heatingType) {
        switch (heatingType){
            case OIL_HEATING -> { return 2.0; }
            case WOOD_HEATING -> { return 1.25; }
            case OTHER_HEATING -> { return 1.0; }
        }
        return 1.0;
    }

    /**
     * overrides the home location type and sets the location type rate
     * @param locationType factor
     * @return
     */

    @Override
    public double getLocationTypeFactor(Home.LocationType locationType) {
        switch (locationType){
            case RURAL_LOCATION -> { return  1.15;}
            case URBAN_LOCATION -> { return 1.0;}
        }
        return 1.0;
    }

    /**
     * overrides the home age factor and sets the age factor rate
     * @param yearsOld
     * @return
     */
    @Override
    public double getHomeAgeFactor(int yearsOld) {
        if (yearsOld > 50){
            return  1.5;
        }else if (yearsOld < 50 && yearsOld >= 25){
            return 1.25;
        }
        return 1.0;
    }

    /**
     * Set the car base premium
     * @return
     */
    @Override
    public double getCarBasePremium() {
        return 750;
    }

    /**
     * Overrides the car age factor and set car age rate
     * @param yearsOld
     * @return
     */
    @Override
    public double getCarAgeFactor(int yearsOld) {
        if (yearsOld > 10){
            return  2.0;

        }else if (yearsOld < 10 && yearsOld >= 5){
            return 1.5;

        }else {
            return 1.0;
        }
    }

    /**
     * Overrides driver age and sets driver age rate
     * @param yearsOld
     * @return
     */
    @Override
    public double getDriverAgeFactor(int yearsOld) {
        if (yearsOld < 25) {
            return 2.0;
        }
       else {
            return 1.0;
        }
    }

    /**
     * Sets the number of accidents rate
     * @param numberOfAccidents
     * @return
     */
    @Override
    public double getHadAccident(int numberOfAccidents) {
       if (numberOfAccidents >= 2 ) {
           return 2.5;
       }
       else if (numberOfAccidents == 1) {
           return 1.25;
       }
       return 1.0;
    }

    @Override
    public double getTaxRate() {
        return 1.15;
    }
}
