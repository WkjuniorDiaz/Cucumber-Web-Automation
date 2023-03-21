package stepDefinitions;

import io.cucumber.java.en.And;
import org.junit.Assert;
import pageObjects.ChooseSeatsPage;
import utils.TestContextSetup;

public class ChooseSeatsStepDefinition {

    TestContextSetup testContextSetup;
    protected ChooseSeatsPage chooseSeatsPage;

    public ChooseSeatsStepDefinition (TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        chooseSeatsPage = testContextSetup.pageObjectManager.getChooseSeats();
    }

    @And("user continue the booking process choosing to select seats later")
    public void user_continue_the_booking_process_choosing_to_select_seats_later(){
        chooseSeatsPage.selectBtnChooseSeatsLater();
        Assert.assertEquals("Bonus Page didn't load","Add what you want",chooseSeatsPage.getBonustitle());
    }

    @And("user continue to payment options")
    public void user_continue_to_payment_options(){
        chooseSeatsPage.confirmBookingDetail();
    }



}
