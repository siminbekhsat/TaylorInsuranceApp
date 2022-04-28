/**
 * The auto policy class for Taylor's insurance
 * @Author SAR_Solutions
 */
public class AutoPolicy extends Policy{
    private VehicleQuote carQuote;

    public AutoPolicy(VehicleQuote carQuote){
        super();
        this.carQuote = carQuote;
    }

    public VehicleQuote getCarQuote(){
        return carQuote;
    }

    public void setCarQuote(VehicleQuote carQuote){
        this.carQuote = carQuote;
    }
}
