package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChooseSeatsPage {

    public WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//circle[@class='sc-gzVnrw AchZE']")
    WebElement loader;

    @FindBy(xpath = "//p[@class='sc-bwzfXH Qetsk']")
    WebElement loadingText;

    @FindBy(id = "btnSeatMapLeave")
    WebElement btnChooseSeatLater;

    @FindBy(xpath = "//span[contains(text(),'Add what you want')]")
    WebElement bonusTitle;

    @FindBy(id = "button-cart-confirm")
    WebElement btnCartConfirm;

    public ChooseSeatsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectBtnChooseSeatsLater(){
        wait.until(ExpectedConditions.invisibilityOf(loadingText));
        wait.until(ExpectedConditions.visibilityOf(btnChooseSeatLater));

        btnChooseSeatLater.click();

    }

    public String getBonustitle(){
        wait.until(ExpectedConditions.visibilityOf(bonusTitle));

        return bonusTitle.getText();
    }

    public void confirmBookingDetail(){
        wait.until(ExpectedConditions.visibilityOf(btnCartConfirm));

        btnCartConfirm.click();

        try{
            Thread.sleep(5000);
        }catch (Exception e){

        }
    }
}
