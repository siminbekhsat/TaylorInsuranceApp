/**
 * The home policy class for Taylor's insurance
 * @Author Simin
 */
public class HomePolicy extends Policy {

    private HomeQuote homeQuote;

    public HomePolicy(HomeQuote quoteHome) {
        super();
        this.homeQuote = quoteHome;
    }

    public HomeQuote getHomeQuote() {
        return homeQuote;
    }

    public void setHomeQuote(HomeQuote homeQuote) {
        this.homeQuote = homeQuote;
    }
}
