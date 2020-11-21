package com.s16665.TAU_s16665_002_Selenium;

//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import static org.junit.jupiter.api.Assertions.*;
//import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.Assert;
import org.testng.annotations.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class XkomPageTest {

    WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) throws Exception {
        if (browser.equalsIgnoreCase("chrome")) {
//          My OS for some reason could not use PATH for "chromedriver.exe".
//          Only firefox driver with the same PATH system env variable works fine.
//          So here is absolute path for chrome.
//          In your environment please comment line below.
            System.setProperty("webdriver.chrome.driver","C:\\Users\\michal\\Projects\\misc\\WebDrivers\\chromedriver.exe");
//          Uncomment if you have set and working PATH for "chromedriver.exe"
//          System.setProperty("webdriver.chrome.driver","chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.firefox.driver","geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("opera")) {
//          My OS for some reason could not use PATH for "operadriver.exe".
//          Only firefox driver with the same PATH system env variable works fine.
//          So here is absolute path for chrome.
//          In your environment please comment line below.
            System.setProperty("webdriver.chrome.driver","C:\\Users\\michal\\Projects\\misc\\WebDrivers\\operadriver.exe");
//          Uncomment if you have set and working PATH for "operadriver.exe"
//          System.setProperty("webdriver.chrome.driver","operadriver.exe");
            driver = new OperaDriver();
        }
        else {
            throw  new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void AddAndRemoveItemFromTheCart() {
        driver.navigate().to("https://www.x-kom.pl/");

        String shoppingItemName = "Logitech M590 Multi Device Silent grafitowy";
        String confirmationMessage ="Produkt dodany do koszyka";
        String pageTitle ="x-kom.pl - Sklep komputerowy";

        By byShoppingItem = By.xpath("//*[@id=\"listing-container\"]/div/div/div[2]/div[2]/div[1]/a/h3/span");
        By bySearchInput = By.cssSelector("input[class='sc-1hdf4hr-0 oGSDO']");
        By bySearchButton = By.cssSelector("button[class='sc-15gi9e9-7 eGSEfi']");
        By byShoppingItemH1 = By.cssSelector("h1[class='sc-1x6crnh-5 cYILyh']");
        By byButtonAddToCart = By.xpath("//*[@id=\"app\"]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div/div[2]/div[2]/div/button");
        By byConfirmationMessage = By.xpath("//h3[text()='Produkt dodany do koszyka']");

        String title = driver.getTitle();
        Assert.assertEquals(title, pageTitle);

        justWaitForVisibilityOf(bySearchInput);
        WebElement elSearchbox = driver.findElement(bySearchInput);
        elSearchbox.click();
        elSearchbox.sendKeys(shoppingItemName);

        justWaitForVisibilityOf(bySearchButton);
        WebElement elSearchButton = driver.findElement(bySearchButton);
        elSearchButton.click();

        justWaitForVisibilityOf(byShoppingItem);
        WebElement elShoppingItem =  driver.findElement(byShoppingItem);
        elShoppingItem.click();

        justWaitForVisibilityOf(byShoppingItemH1);
        Assert.assertEquals(driver.findElement(byShoppingItemH1).getText(), shoppingItemName);

        justWaitForVisibilityOf(byButtonAddToCart);
        WebElement elButtonAddToCart =  driver.findElement(byButtonAddToCart);
        elButtonAddToCart.click();

        justWaitForVisibilityOf(byConfirmationMessage);
        Assert.assertEquals(driver.findElement(byConfirmationMessage).getText(), confirmationMessage);


    }

    @Test
    public void RedirectToLoginPage() {
        driver.navigate().to("https://www.x-kom.pl/");

        String pageTitle ="x-kom.pl - Sklep komputerowy";
        String logInLabel ="Zaloguj się";

        By byYourAccount = By.xpath("//div[text()='Twoje konto']");
        By byYourOrders= By.xpath("//div[text()='Zamówienia']");
        By byLoginInBox = By.xpath("//h2[text()='Zaloguj się']");

        String title = driver.getTitle();
        Assert.assertEquals(title, pageTitle);

        WebElement elYourAccount = driver.findElement(byYourAccount);
        elYourAccount.click();

        WebElement elYourOrders = driver.findElement(byYourOrders);
        elYourOrders.click();

        justWaitForVisibilityOf(byLoginInBox);
        Assert.assertEquals(driver.findElement(byLoginInBox).getText(), logInLabel);
    }

    @AfterTest
    public void teardown(){
        if (driver != null) {
            driver.quit();
        }
    }

    void justWaitForVisibilityOf(By by) {
        WebElement el = driver.findElement(by);
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(el));

    }
}















