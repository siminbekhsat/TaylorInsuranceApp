import java.time.LocalDate;
import java.time.Period;

/**
 * Home object for Taylor's insurance.
 * Include enums for heating and location type which will be used in rating
 * @Author SAR_Solutions
 */
public class Home {
    private Client client;

    /**
     * Heating type enum
     */
    public enum HeatingType {
        OIL_HEATING,
        WOOD_HEATING,
        OTHER_HEATING,
    }
    private HeatingType heatingType;

    /**
     * Location type enum
     */
    public enum LocationType {
        URBAN_LOCATION,
        RURAL_LOCATION,
    }
    private LocationType locationType;

    private double homeValue;
    private LocalDate yearBuilt;
    private String homeStreetNumber;
    private String homeStreetName;
    private String homeAddressCity;
    private String homePostalCode;

    /**
     * Create a new home object for Taylor's insurance
     * @param client
     * @param homeValue
     * @param yearBuilt
     * @param heatingType
     * @param locationType
     * @param homeStreetNumber
     * @param homeStreetName
     * @param homeAddressCity
     * @param homePostalCode
     */
    public Home(Client client, double homeValue,
                LocalDate yearBuilt, HeatingType heatingType,
                LocationType locationType, String homeStreetNumber,
                String homeStreetName, String homeAddressCity,
                String homePostalCode) {
        this.client = client;
        this.homeValue = homeValue;
        this.yearBuilt = yearBuilt;
        this.heatingType = heatingType;
        this.locationType = locationType;
        this.homeStreetNumber = homeStreetNumber;
        this.homeStreetName = homeStreetName;
        this.homeAddressCity = homeAddressCity;
        this.homePostalCode = homePostalCode;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public HeatingType getHeatingType() {
        return heatingType;
    }

    public void setHeatingType(HeatingType heatingType) {
        this.heatingType = heatingType;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    public double getHomeValue() {
        return homeValue;
    }

    public void setHomeValue(double homeValue) {
        this.homeValue = homeValue;
    }

    public LocalDate getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(LocalDate yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public String getHomeStreetNumber() {
        return homeStreetNumber;
    }

    public void setHomeStreetNumber(String homeStreetNumber) {
        this.homeStreetNumber = homeStreetNumber;
    }

    public String getHomeStreetName() {
        return homeStreetName;
    }

    public void setHomeStreetName(String homeStreetName) {
        this.homeStreetName = homeStreetName;
    }

    public String getHomeAddressCity() {
        return homeAddressCity;
    }

    public void setHomeAddressCity(String homeAddressCity) {
        this.homeAddressCity = homeAddressCity;
    }

    public String getHomePostalCode() {
        return homePostalCode;
    }

    public void setHomePostalCode(String homePostalCode) {
        this.homePostalCode = homePostalCode;
    }

    /**
     * Calculate home age
     * @return home age
     */
    public int getHomeAge() {
        if ((this.yearBuilt != null) && (LocalDate.now() != null)){
            return Period.between(this.yearBuilt, LocalDate.now()).getYears();
        }else{
            return 0;
        }
    }
}
