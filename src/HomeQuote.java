import java.time.LocalDate;

/**
 * The home quote class for Taylor's insurance
 * @Author SAR_Solutions
 */
public class HomeQuote extends Quote {
    private Home quotedHome;

    /**
     * Home quote constructor
     * @param quoteStartDate
     * @param quoteEndDate
     * @param quotedHome
      */
    public HomeQuote(LocalDate quoteStartDate, LocalDate quoteEndDate, Home quotedHome) {
        super(quoteStartDate, quoteEndDate);
        this.quotedHome = quotedHome;
    }

    public Home getQuotedHome() {
        return quotedHome;
    }
}
