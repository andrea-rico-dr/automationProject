package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static pages.ProductPage.*;
import static pages.RegistrationPage.returnDriverRegistration;

public class ProductPage {
    /*@Given("that the user is in the product page")
    public static void  userNavigatesToProductPage() throws InterruptedException {
        accessProductPage(returnDriver());
    }*/

    @And("that the user is in the product page")
    public static void  userNavigatesToProductPage() throws InterruptedException {
        accessProductPage(returnDriverRegistration());
    }

    @When("the user clicks on the ADD TO CART button")
    public static void userAddsProductToCart(){
        addToCart();
    }

    @Then("the confirmation modal is displayed")
    public static void confirmationModalIsDisplayed(){
        modalIsDisplayed();
    }

    @And("the product is added to the shopping cart")
    public static void confirmationMessageIsDisplayed(){
        productWasAddedToCart();
    }
}
