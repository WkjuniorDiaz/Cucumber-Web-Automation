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

    @FindBy(id = "listAutoComplete")
    WebElement listAutomcomplete;

    @FindBys(@FindBy(xpath = "//div[@class='sc-fepxGN dXkMZp']"))
    List<WebElement> listAutocompleteOptions;

    @FindBy(id = "txtInputDestination_field")
    WebElement destinationField;

    @FindBy(id = "departureDate")
    WebElement departureField;

    @FindBys(@FindBy(xpath = "//td[contains(@class,'CalendarDay')]"))
    List<WebElement> listDateOption;

    @FindBy(id = "btnSearchCTA")
    WebElement searchBtn;

    @FindBy(id = "titleSelectFlightDesktop")
    WebElement flightOffersTitle;

    @FindBy(xpath = "//ol[@aria-label='Available flights.']")
    WebElement flightOption;



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
        originField.click();
    }

    public void sendOrigin(String origin){
        originField.sendKeys(origin);
    }

    public void selectAutocompleteOption(String origin){
        wait.until(ExpectedConditions.visibilityOfAllElements(listAutocompleteOptions));
        for (WebElement currentElement:listAutocompleteOptions) {
            if (currentElement.getText().toLowerCase().contains(origin.toLowerCase())) {
                currentElement.click();
            }
        }
    }

    public void sendDestination(String destination){
        destinationField.sendKeys(destination);
    }

    public void selectDepartureField(){
        departureField.click();
    }

    public void selectDateOfTravel(String date){
       for (int i = 0; i < listDateOption.size(); i++){
            if (listDateOption.get(i).getAttribute("aria-label").contains(date)){
                listDateOption.get(i).click();
                break;
            }
        }
    }

    public void selectSearchBtn(){
        searchBtn.click();
    }

    public String getTitleFlightOffers(){
        wait.until(ExpectedConditions.visibilityOf(flightOffersTitle));

        return  flightOffersTitle.getText();
    }

    public boolean verifyDepartureFlightList(){
        boolean isListPresent = false;

        isListPresent = flightOption.isDisplayed();

        return isListPresent;

    }



}
