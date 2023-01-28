package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    public WebDriver driver;
    public LoginPage loginPage;
    public SearchPage searchPage;

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
}
