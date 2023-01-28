package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
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
        searchPage.selectOrigin(origin);
    }

}
