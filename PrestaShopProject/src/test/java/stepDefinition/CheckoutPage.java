package stepDefinition;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import utility.BrowserDriver;


import static pages.RegistrationPage.*;
import static pages.ProductPage.*;
import static pages.CheckoutPage.*;

public class CheckoutPage {

    @Given("that the user is registered and logged in")
    public void userRegistersAndIsLoggedIn() throws InterruptedException {
        accessRegistrationPage();
        clickSocialTitle();
        sendKeysFirstName();
        sendKeysLastName();
        sendKeysEmail();
        sendKeysPassword();
        sendKeysBirthdate();
        clickTermsAndConditions();
        clickDataPrivacy();
        clickSave();
    }
    @And("the user has products in the cart")
    public void userHasProductsInCart() throws InterruptedException {
        accessProductPage(returnDriverRegistration());
        addToCart();
        modalIsDisplayed();
    }

    @And("the user is the shopping cart page")
    public void userIsInShoppingCartPage() throws InterruptedException {
        accessShoppingCart(returnDriverProduct());
    }

    @When("the user clicks on PROCEED TO CHECKOUT button")
    public void userProceedsToCheckout(){
        proceedToCheckout();
    }

    @And("the users fills valid address, shipping and payment information")
    public void userFillsInformation(){
        fillAddressesInformation();
        clickContinueToShipment();
        clickContinueToPayment();
        clickAgreeToTermsOfService();
    }

    @And("clicks on the PLACE ORDER button")
    public void userClicksPlaceOrder(){
        clickPlaceOrder();
    }

    @Then("an order confirmation message is displayed")
    public void orderIsConfirmed(){
        orderConfirmation();
    }
}
