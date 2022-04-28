import java.time.LocalDate;
import java.time.Period;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *The core client value for Taylor's Insurance system
 * All drivers will be clients, There will only be one client on any insurance policy.
 * @Author SAR_Solutions
 */

public class Client {
    private String clientFName;
    private String clientLName;
    LocalDate clientDOB;
    private String address;
    private String postalCode;

    /**
     * Create a new client object for Taylor's insurance
     * @param clientFName
     * @param clientLName
     * @param clientDOB
     */

    public Client(String clientFName, String clientLName, LocalDate clientDOB) {
        this.clientFName = clientFName;
        this.clientLName = clientLName;
        this.clientDOB = clientDOB;
    }

    public String getClientFName() {
        return clientFName;
    }

    public void setClientFName(String clientFName) {
        this.clientFName = clientFName;
    }

    public String getClientLName() {
        return clientLName;
    }

    public void setClientLName(String clientLName) {
        this.clientLName = clientLName;
    }

    public LocalDate getClientDOB() {
        return clientDOB;
    }

    public void setClientDOB(LocalDate clientDOB) {
        this.clientDOB = clientDOB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Calculate client age
     * @return client age
     */
    public int getClient_age() {
        if ((this.clientDOB != null) && (LocalDate.now() != null)){
            return Period.between(this.clientDOB, LocalDate.now()).getYears();
        }else{
            return 0;
        }
    }
}
