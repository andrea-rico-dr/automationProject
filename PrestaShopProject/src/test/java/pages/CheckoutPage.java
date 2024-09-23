package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utility.BrowserDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;
import static utility.BrowserDriver.driver;

public class CheckoutPage {

    public static String homeUrl;
    public static String address_xpath = "//*[@id='field-address1']";
    public static String city_xpath = "//*[@id='field-city']";
    public static String state_xpath = "//*[@id='field-id_state']";
    public static String zipCode_xpath = "//*[@id='field-postcode']";
    public static String phone_xpath = "//*[@id='field-phone']";
    public static String continueButton_xpath = "//button[@type='submit' and @name='confirm-addresses']";


    public static void  accessShoppingCart(WebDriver driver) throws InterruptedException {
        driver.get("https://demo.prestashop.com/#/en/front");
        System.setProperty("webdriver.chrome/driver", System.getProperty("user.dir")+ "/src/test/resources/drivers/chrome.exe");
        sleep(10000);
        WebElement iframeElement = driver.findElement(By.id("framelive"));
        String srcValue = iframeElement.getAttribute("src");
        homeUrl = srcValue.split("/en")[0];
        String url = homeUrl + "/en/cart?action=show";
        driver.get(url);
    }

    public static void proceedToCheckout(){
        driver.findElement(By.xpath("//div[@class='text-sm-center']/a[contains(text(), 'Proceed')]")).click();
    }

    public static void fillAddressesInformation(){
        driver.findElement(By.xpath(address_xpath)).sendKeys("Test Address St.");
        driver.findElement(By.xpath(city_xpath)).sendKeys("test city");

        Select select = new Select(driver.findElement(By.xpath(state_xpath)));
        select.selectByVisibleText("Florida");

        driver.findElement(By.xpath(zipCode_xpath)).sendKeys("12345");
        driver.findElement(By.xpath(phone_xpath)).sendKeys("1234567890");

    }
    public static void clickContinueToShipment(){
        driver.findElement(By.xpath(continueButton_xpath)).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout-delivery-step")));
    }

    public static void clickContinueToPayment(){
        driver.findElement(By.xpath("//button[@name='confirmDeliveryOption' and @type='submit']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout-payment-step")));
    }

    public static void clickAgreeToTermsOfService(){
        driver.findElement(By.id("conditions_to_approve[terms-and-conditions]")).click();
    }

    public static void clickPlaceOrder(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Place order']")));
    }

    public static void orderConfirmation(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout-modal")));

        assertTrue("Order confirmation modal is displayed", modal.isDisplayed());

        String modalTitle = driver.findElement(By.id("myConfirmationModalLabel")).getText();
        String expectedMessage = "Order Confirmed";

        Assert.assertTrue("Modal message should confirm the order", modalTitle.contains(expectedMessage));
    }

}
