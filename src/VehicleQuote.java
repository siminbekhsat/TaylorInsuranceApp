import java.time.LocalDate;

/**
 * The car quote class for Taylor's insurance
 * @Author SAR_Solutions
 */
public class VehicleQuote extends Quote {
    private Vehicle quotedVehicle;


    /**
     * Car quote constructor
     * @param quoteStartDate
     * @param quoteEndDate
     * @param quotedVehicle
     */
    public VehicleQuote(LocalDate quoteStartDate, LocalDate quoteEndDate, Vehicle quotedVehicle) {
        super(quoteStartDate, quoteEndDate);
        this.quotedVehicle = quotedVehicle;
    }

    public Vehicle getQuotedCar() {
        return quotedVehicle;
    }
}
