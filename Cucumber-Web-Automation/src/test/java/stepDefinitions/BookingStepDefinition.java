package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.BookingPage;
import utils.TestContextSetup;

public class BookingStepDefinition {

    TestContextSetup testContextSetup;
    protected BookingPage bookingPage;

    public BookingStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        bookingPage = testContextSetup.pageObjectManager.getBookingPage();
    }

    @When("choose a departure flight base on start feature {string} of the flight")
    public void user_select_second_earlier_departure_flight(String starFeature){
        bookingPage.selectFlight(starFeature);
    }

    @And("select type of luggage {string}")
    public void select_type_of_luggage(String luggage){
        bookingPage.selectLuggage(luggage);
        Assert.assertEquals("Trip summary",bookingPage.getTripSummaryTitle());
    }

    @And("choose a return flight base on start feature {string} of the flight")
    public void choose_a_return_flight(String starFeature){
        bookingPage.selectFlight(starFeature);
    }

    @And("select button to select seats")
    public void select_btn_select_seats(){
        bookingPage.selectBtnSelectSeats();
    }


}
