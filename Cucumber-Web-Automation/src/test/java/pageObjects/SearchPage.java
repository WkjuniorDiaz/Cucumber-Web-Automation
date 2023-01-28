package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {
    public WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "country-suggestion-dialog-title")
    WebElement suggestionModal;

    @FindBy(id = "country-suggestion-dialog-close")
    WebElement suggestionClose;

    @FindBy(xpath = "//button[@class='sc-cOoQYZ epQUAu']")
    WebElement roundTripBtn;

    @FindBy(id = "lstSearchBoxTripType")
    WebElement listSearchTripType;

    @FindBys(@FindBy(xpath = "//button[@class='sc-jrOYZv eIhUsC']"))
    List<WebElement> listTripTypeOptions;

    @FindBy(id = "btnCabinTypeCTA" )
    WebElement typeCabinOption;

    @FindBy(id = "lstSearchBoxCabinType")
    WebElement listSearchCabinType;

    @FindBys(@FindBy(xpath = "//button[@class='sc-jBoNkH gMiDp']"))
    List<WebElement> listCabinTypeOptions;

    @FindBy(id = "txtInputOrigin_field")
    WebElement originField;



    public SearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void closeSwitchModal(){
        wait.until(ExpectedConditions.visibilityOf(suggestionModal));
        suggestionClose.click();
    }

    public void selectTypeTrip(String trip){
        wait.until(ExpectedConditions.visibilityOf(roundTripBtn));
        roundTripBtn.click();
        wait.until(ExpectedConditions.visibilityOf(listSearchTripType));
        for (int i = 0; i < listTripTypeOptions.size(); i++){
            if (listTripTypeOptions.get(i).getText().contains(trip)){
                listTripTypeOptions.get(i).click();
            }
        }
    }

    public void selectTypeCabin(String cabin){
        typeCabinOption.click();
        wait.until(ExpectedConditions.visibilityOf(listSearchCabinType));
        for (int i= 0; i < listCabinTypeOptions.size(); i++){
            if (listCabinTypeOptions.get(i).getText().contains(cabin)){
                listCabinTypeOptions.get(i).click();
            }
        }
    }

    public void selectOriginField(){
        System.out.println("**");
        originField.click();
        try {
            Thread.sleep(5000);
        }catch (Exception e){
        }
    }

    public void selectOrigin(String origin){
        originField.sendKeys(origin);

        try {
            Thread.sleep(5000);
        }catch (Exception e){
        }

        System.out.println("--");
    }
}
