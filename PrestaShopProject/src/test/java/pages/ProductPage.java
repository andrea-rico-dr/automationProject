package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserDriver;

import java.time.Duration;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class ProductPage extends BrowserDriver {

    public static String homeUrl;
    public static String quantity;
    //public static WebDriver driver = new ChromeDriver();


    public static void accessProductPage(WebDriver driver) throws InterruptedException {
        //WebDriverManager.chromedriver().setup();
        driver.get("https://demo.prestashop.com/#/en/front");
        System.setProperty("webdriver.chrome/driver", System.getProperty("user.dir")+ "/src/test/resources/drivers/chrome.exe");
        Thread.sleep(10000);
        WebElement iframeElement = driver.findElement(By.id("framelive"));
        String srcValue = iframeElement.getAttribute("src");
        homeUrl = srcValue.split("/en")[0];
        String url = homeUrl + "/men/1-1-hummingbird-printed-t-shirt.html#/1-size-s/8-color-white";
        driver.get(url);
    }

    public static void addToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-button-action='add-to-cart']")));
        driver.findElement(By.xpath("//button[@data-button-action='add-to-cart']")).click();
    }

    public static void modalIsDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("blockcart-modal")));

        assertTrue("Confirmation modal is displayed", modal.isDisplayed());
    }

    public static void productWasAddedToCart(){
        String modalTitle = driver.findElement(By.id("myModalLabel")).getText();
        String expectedMessage = "Product successfully added to your shopping cart";

        Assert.assertTrue("Modal message should contain the confirmation message", modalTitle.contains(expectedMessage));
    }

    public static WebDriver returnDriverProduct(){
        return driver;
    }
}
