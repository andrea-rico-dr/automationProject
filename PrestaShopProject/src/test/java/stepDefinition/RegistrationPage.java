package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static pages.RegistrationPage.*;

public class RegistrationPage {

    @Given("that the user is in the Registration page")
    public void userNavigatesToRegistrationPage() throws InterruptedException {
        accessRegistrationPage();
    }

    @When("the users fills the form with valid information")
    public void userFillsRegistrationForm() throws InterruptedException {
        clickSocialTitle();
        sendKeysFirstName();
        sendKeysLastName();
        sendKeysEmail();
        sendKeysPassword();
        sendKeysBirthdate();
        clickTermsAndConditions();
        clickDataPrivacy();
    }

    @And("clicks on the Save button")
    public void userClicksSaveButton() throws InterruptedException {
        clickSave();
    }

    @Then("the user is redirected to the home page")
    public void testUserIsRedirected(){
        testUserRedirection();
    }

    @And("the user is logged in")
    public void testUserIsLogged(){
        testUserIsLoggedIn();
    }


}
