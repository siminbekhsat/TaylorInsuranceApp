import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The core policy object for Taylor's insurance.
 * This is an abstract object that manages the policy hierarchy.
 * @Author SAR_Solutions
 */
    abstract class Policy {
    private Date policyStartDate;
    private Date policyEndDate;
    private Date policyCreateDate;
    private double policyPremium;


    public Date getPolicyStartDate() {
        return policyStartDate;
    }

    public void setPolicyStartDate(Date policyStartDate) {
        this.policyStartDate = policyStartDate;
    }

    public Date getPolicyEndDate() {
        return policyEndDate;
    }

    public void setPolicyEndDate(Date policyEndDate) {
        this.policyEndDate = policyEndDate;
    }

    public Date getPolicyCreateDate() {
        return policyCreateDate;
    }

    public void setPolicyCreateDate(Date policyCreateDate) {
        this.policyCreateDate = policyCreateDate;
    }

    public double getPolicyPremium() {
        return policyPremium;
    }

    public void setPolicyPremium(double policyPremium) {
        this.policyPremium = policyPremium;
    }
}
