package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BookingPage {

    public WebDriver driver;
    WebDriverWait wait;

    @FindBys(@FindBy(xpath = "//span[contains(@class,'card-flightstyle__FlightSummary')]"))
    List<WebElement> starFeatureFlight;

    @FindBys(@FindBy(xpath = "//span[@class='columnBrandstyle__BrandName-sc__sc-1e0tr9m-4 eCbTSs']"))
    List<WebElement> typeLuggage;

    By btnChoose = By.id("bundle-detail-2-flight-select");

    By titleTripSummary = By.xpath("//h3[@aria-label='Trip summary.']");

    @FindBy( xpath = "//span[contains(text(),'Go to seats')]")
    WebElement btnSelectSeats;




    public BookingPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectFlight(String starFeature){
        wait.until(ExpectedConditions.visibilityOfAllElements(starFeatureFlight));

        for (int i = 0; i< starFeatureFlight.size(); i++){
            if (starFeatureFlight.get(i).getText().equals(starFeature)){
                    starFeatureFlight.get(i).click();
                    break;
            }
        }
    }

    public void selectLuggage(String luggage){
        wait.until(ExpectedConditions.visibilityOfAllElements(typeLuggage));

        for (int i = 0; i < typeLuggage.size(); i++){
            if (typeLuggage.get(i).getText().equals(luggage)){
                driver.findElement(btnChoose).click();
                break;
            }
        }
    }

    public String getTripSummaryTitle(){

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(titleTripSummary)));

        return driver.findElement(titleTripSummary).getText();
    }

    public void selectBtnSelectSeats(){
        wait.until(ExpectedConditions.visibilityOf(btnSelectSeats));

        btnSelectSeats.click();
    }


}
