package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.LoginPage;
import utils.TestContextSetup;

public class LoginStepDefinition {

    TestContextSetup testContextSetup;
    protected LoginPage loginPage;

    public LoginStepDefinition (TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        loginPage = testContextSetup.pageObjectManager.getLoginPage();
    }

    @When("user type username {string}")
    public void user_type_username(String username){
        loginPage.setUsername(username);
    }

    @And("user type password {string}")
    public void user_type_password(String password){
        loginPage.setPassword(password);
    }

    @And("user select button login")
    public void user_select_button_login(){
        loginPage.selectLoginBtn();
    }

    @Then("user log into setup page")
    public void user_log_into_setup_page(){
        Assert.assertEquals("user not log in","Intranet Bundle",loginPage.getTitlePage());
    }






}
