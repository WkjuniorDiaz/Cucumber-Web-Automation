package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.SearchPage;
import utils.TestContextSetup;

public class SearchStepDefinition {
    TestContextSetup testContextSetup;
    protected SearchPage searchPage;

    public SearchStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        searchPage = testContextSetup.pageObjectManager.getSearchPage();
    }

    @Given("user close switch modal")
    public void user_close_switch_modal(){
        searchPage.closeSwitchModal();
    }

    @Given("user select type of trip {string}")
    public void user_select_type_of_trip(String trip){
        searchPage.selectTypeTrip(trip);
    }

    @Given("user select type of cabin {string}")
    public void user_select_type_of_cabin(String cabin){
        searchPage.selectTypeCabin(cabin);
    }

    @When("user select origin field")
    public void user_select_origin_field(){
        searchPage.selectOriginField();
    }

    @And("user type origin {string}")
    public void user_type_origin(String origin){
        searchPage.sendOrigin(origin);
    }

    @And("user select destination origin {string}")
    public void user_select_destination_origin(String origin){
        searchPage.selectAutocompleteOption(origin);
    }

    @And("user type destination {string}")
    public void user_type_destination(String destination){
        searchPage.sendDestination(destination);
    }

    @And("user select destination {string}")
    public void user_select_destination(String destination){
        searchPage.selectAutocompleteOption(destination);
    }

    @And("user select departure field")
    public void user_select_departure_field(){
        searchPage.selectDepartureField();
    }

    @And("user select departure date {string}")
    public void user_select_departure_date(String departureDate){
        searchPage.selectDateOfTravel(departureDate);
    }

    @And("user select return date {string}")
    public void user_select_return_date(String returnDate){
        searchPage.selectDateOfTravel(returnDate);
    }

    @And("user select search button")
    public void user_select_search_button(){
        searchPage.selectSearchBtn();
    }

    @Then("title of available flights page is displayed")
    public void title_of_select_flight_displayed(){
        Assert.assertEquals("title is not displayed","Choose a departure flight\nChoose a departure flight",searchPage.getTitleFlightOffers());
    }

    @And("user should see available flight list")
    public void user_should_see_departure_flight_list(){
        Assert.assertTrue("list of departure flight is not present",searchPage.verifyDepartureFlightList());
    }

    @Given("user search for a flight with origin {string}, destination {string}, departure date {string} and return date {string}")
    public void searchFlight(String origin, String destination, String departureDate, String returnDate){
        searchPage.selectOriginField();
        searchPage.sendOrigin(origin);
        searchPage.selectAutocompleteOption(origin);
        searchPage.sendDestination(destination);
        searchPage.selectAutocompleteOption(destination);
        searchPage.selectDepartureField();
        searchPage.selectDateOfTravel(departureDate);
        searchPage.selectDateOfTravel(returnDate);
        searchPage.selectSearchBtn();
        searchPage.closeSwitchModal();
        Assert.assertTrue("list of departure flight is not present",searchPage.verifyDepartureFlightList());
    }


}
