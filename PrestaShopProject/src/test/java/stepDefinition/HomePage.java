package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static pages.HomePage.*;

public class HomePage {

    @Given("that the user is on the homepage")
    public static void userAccessHomePage() throws InterruptedException {
        accessHomePage();
    }

    @Then("the available products are displayed")
    public static void usersCanSeeAvailableProducts(){
      productsAreDisplayed();
    }

    @And("the product is displayed with its corresponding name and price")
    public static void productsHaveNameAndPrice(){
        productsHaveDetails();
    }

}
