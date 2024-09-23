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

public class RegistrationPage extends BrowserDriver {

    public static String socialTitle_xpath = "//*[@id='field-id_gender-2']";
    public static String firstName_xpath = "//*[@id='field-firstname']";
    public static String lastName_xpath = "//*[@id='field-lastname']";
    public static String email_xpath = "//*[@id='field-email']";
    public static String password_xpath = "//*[@id='field-password']";
    public static String birthdate_xpath = "//*[@id='field-birthday']";
    public static String termsAndConditions_xpath = "//input[@name='psgdpr']";
    public static String dataPrivacy_xpath = "//input[@name='customer_privacy']";
    public static String save_xpath = "//*[@data-link-action='save-customer']";
    public static String signOutButton_xpath = "//*[@id=\"_desktop_user_info\"]/div/a[1]";
    public static String homeUrl;


    public static void accessRegistrationPage() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.prestashop.com/#/en/front");
        System.setProperty("webdriver.chrome/driver", System.getProperty("user.dir")+ "/src/test/resources/drivers/chrome.exe");
        Thread.sleep(10000);
        WebElement iframeElement = driver.findElement(By.id("framelive"));
        String srcValue = iframeElement.getAttribute("src");
        homeUrl = srcValue.split("/en")[0];
        String url = homeUrl + "/registration";
        driver.get(url);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content")));
    }

    public static void clickSocialTitle(){

        driver.findElement(By.xpath(socialTitle_xpath)).click();
    }

    public static void sendKeysFirstName(){

        driver.findElement(By.xpath(firstName_xpath)).sendKeys("Andrea");
    }
    public static void sendKeysLastName(){

        driver.findElement(By.xpath(lastName_xpath)).sendKeys("Test");
    }
    public static void sendKeysEmail(){
        Random random = new Random();
        driver.findElement(By.xpath(email_xpath)).sendKeys("andrea.test"+String.valueOf(random.nextInt(10000))+"@test.com");
    }
    public static void sendKeysPassword(){

        driver.findElement(By.xpath(password_xpath)).sendKeys("P@ssword12345!");
    }
    public static void sendKeysBirthdate(){
        driver.findElement(By.xpath(birthdate_xpath)).sendKeys("02/13/1968");
    }
    public static void clickTermsAndConditions(){
        driver.findElement(By.xpath(termsAndConditions_xpath)).click();
    }
    public static void clickDataPrivacy(){
        driver.findElement(By.xpath(dataPrivacy_xpath)).click();
    }
    public static void clickSave(){
        driver.findElement(By.xpath(save_xpath)).click();
    }

    public static void testUserRedirection(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("_desktop_user_info")));

        String expectedUrl = homeUrl + "/en/";
        String currentUrl = driver.getCurrentUrl();

        Assert.assertEquals("User was not redirected to the home page.", expectedUrl, currentUrl);

    }

    public static void testUserIsLoggedIn(){
        String expectedText = "Sign out";
        String actualText = driver.findElement(By.xpath(signOutButton_xpath)).getText().replaceAll("[^\\p{Print}]", "").trim();
        Assert.assertEquals("User is not logged in", expectedText, actualText);
    }

    public static WebDriver returnDriverRegistration(){
        return driver;
    }
}
