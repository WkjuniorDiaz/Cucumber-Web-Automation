package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    public WebDriver driver;
    public LoginPage loginPage;
    public SearchPage searchPage;
    public BookingPage bookingPage;
    public ChooseSeatsPage chooseSeatsPage;

    public PageObjectManager (WebDriver driver){
        this.driver = driver;
    }

    public LoginPage getLoginPage(){
        loginPage = new LoginPage(driver);
        return  loginPage;
    }

    public SearchPage getSearchPage(){
        searchPage = new SearchPage(driver);
        return searchPage;
    }

    public BookingPage getBookingPage(){
        bookingPage = new BookingPage(driver);
        return bookingPage;
    }

    public ChooseSeatsPage getChooseSeats(){
        chooseSeatsPage = new ChooseSeatsPage(driver);
        return chooseSeatsPage;
    }
}
