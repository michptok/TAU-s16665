package com.s16665.TAU_s16665_002_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TrjPageTest {

    WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) throws Exception {
        if (browser.equalsIgnoreCase("chrome")) {
//          My OS for some reason could not use PATH for "chromedriver.exe".
//          Other drivers with the same PATH system env variable works fine.
//          So here is absolute path for chrome.
//          In your environment please comment line below.
            System.setProperty("webdriver.chrome.driver","C:\\Users\\michal\\Projects\\misc\\WebDrivers\\chromedriver.exe");
//          Uncomment if you have set and working PATH for "chromedriver.exe"
//            System.setProperty("webdriver.chrome.driver","chromedriver.exe");
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
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void addComment() {
        driver.navigate().to("https://www.trojmiasto.pl/");

        String pageTitle ="Trojmiasto.pl - wiadomości i informacje z Trójmiasta.";
        double randomDouble = Math.random() * (9000 - 1000 + 1) + 1000;
        int authorAsANumber = (int)randomDouble;
        String commentAuthor = String.valueOf(authorAsANumber);
        String commentContent = "Podoba mi się";
        String commentTitle = "Interesujące";



        By byFirstSidebarNews = By.xpath("//*[@id=\"cntSidebar\"]/div[2]/div/div/ul/li[3]/div/a");
        By xxxx = By.xpath("//html/body/div[2]/div/div/div[1]/div/div[2]/button");
        By byAddOpinion = By.cssSelector("button.Opinions__add");
        By byInputTitle = By.xpath("/html/body/div[2]/div/div/div[1]/div/div[2]/div[1]/div/div[2]/form/input[7]");
        By byInputContent = By.xpath("/html/body/div[2]/div/div/div[1]/div/div[2]/div[1]/div/div[2]/form/textarea");
        By byInputAuthor = By.cssSelector("input[placeholder=\"Autor (opcjonalny)\"]");


        String title = driver.getTitle();
        Assert.assertEquals(title, pageTitle);

        justWaitForVisibilityOf(byFirstSidebarNews);
        WebElement elFirstSidebarNews = driver.findElement(byFirstSidebarNews);
        elFirstSidebarNews.click();

        pause(10);
        justWaitForVisibilityOf(byAddOpinion);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(byAddOpinion)).click();

        pause(10);
        justWaitForVisibilityOf(byInputTitle);
        WebElement elInputTitle = driver.findElement(byInputTitle);
        elInputTitle.click();
        elInputTitle.sendKeys(commentTitle);

        justWaitForVisibilityOf(byInputContent);
        WebElement elInputContent = driver.findElement(byInputContent);
        elInputContent.click();
        elInputContent.sendKeys(commentContent);

        justWaitForVisibilityOf(byInputAuthor);
        WebElement eInputAuthor = driver.findElement(byInputAuthor);
        eInputAuthor.click();
        eInputAuthor.sendKeys(commentAuthor);

    }

    @Test
    public void findPastaMiasta() {
        driver.navigate().to("https://www.trojmiasto.pl/");

        String pageTitle = "Trojmiasto.pl - wiadomości i informacje z Trójmiasta.";
        String companyName = "Pasta Miasta";

        String title = driver.getTitle();
        Assert.assertEquals(title, pageTitle);

        By byFood = By.xpath("//a[@title='Jedzenie na telefon']");
        By byInputCompany = By.cssSelector("input[placeholder='Znajdź firmę']");
        By byCompanyHeader = By.xpath("//h1/a/span[text()=\"Pasta Miasta\"]");
        By bySubmitCompany = By.cssSelector("input[id='cat_search_submit_button']");

        justWaitForVisibilityOf(byFood);
        WebElement elFood = driver.findElement(byFood);
        elFood.click();

        pause(5);
        justWaitForVisibilityOf(byInputCompany);
        WebElement elInputCompany = driver.findElement(byInputCompany);
        elInputCompany.click();
        elInputCompany.sendKeys(companyName);

        justWaitForVisibilityOf(bySubmitCompany);
        WebElement elSubmitCompany = driver.findElement(bySubmitCompany);
        elSubmitCompany.click();

        pause(5);
        justWaitForVisibilityOf(byCompanyHeader);
        WebElement elCompanyHeader = driver.findElement(byCompanyHeader);
        Assert.assertEquals(elCompanyHeader.getText(), companyName );

    }

    @AfterTest
    public void teardown(){
        if (driver != null) {
            driver.quit();
        }
    }

    void justWaitForVisibilityOf(By by) {
        WebElement el = driver.findElement(by);
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(el));
    }

    void pause(Integer seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}















