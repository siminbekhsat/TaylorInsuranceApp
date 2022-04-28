import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The core quote object for Taylor's insurance.
 * This is an abstract object that manages the quote hierarchy.
 * @Author SAR_Solutions
 */
abstract class Quote {
    private LocalDate quoteStartDate;
    private LocalDate quoteEndDate;

    /**
     * Create quote object
     * @param quoteStartDate
     * @param quoteEndDate
     */
    public Quote(LocalDate quoteStartDate, LocalDate quoteEndDate) {
        this.quoteStartDate = quoteStartDate;
        this.quoteEndDate = quoteEndDate;
    }

    public LocalDate getQuoteStartDate() {
        return quoteStartDate;
    }

    public void setQuoteStartDate(LocalDate quoteStartDate) {
        this.quoteStartDate = quoteStartDate;
    }

    public LocalDate getQuoteEndDate() {
        return quoteEndDate;
    }

    public void setQuoteEndDate(LocalDate quoteEndDate) {
        this.quoteEndDate = quoteEndDate;
    }

}
