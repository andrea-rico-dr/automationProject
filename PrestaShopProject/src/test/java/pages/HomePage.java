package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserDriver;

import java.time.Duration;
import java.util.List;

public class HomePage extends BrowserDriver {

    public static void accessHomePage() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.prestashop.com/#/en/front");
        System.setProperty("webdriver.chrome/driver", System.getProperty("user.dir")+ "/src/test/resources/drivers/chrome.exe");
        Thread.sleep(10000);
        WebElement iframeElement = driver.findElement(By.id("framelive"));
        String srcValue = iframeElement.getAttribute("src");
        String extractedSrc = srcValue.split("/en")[0];
        driver.get(extractedSrc);
    }

    public static void productsAreDisplayed(){
        List<WebElement> products = driver.findElements(By.className("featured-products"));
        assert !products.isEmpty();
    }

    public static void productsHaveDetails(){
        List<WebElement> products = driver.findElements(By.className("featured-products"));

        for (WebElement product : products) {
            String productName = product.findElement(By.cssSelector("h3.h3.product-title a")).getText();
            String productPrice = product.findElement(By.xpath("//span[@class='regular-price']")).getText(); // Adjust the selector

            assert !productName.isEmpty() : "No product name";
            assert !productPrice.isEmpty() : "No product price";
        }
    }


}
