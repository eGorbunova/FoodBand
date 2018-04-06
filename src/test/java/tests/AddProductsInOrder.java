package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddProductsInOrder {

    private static final String URL = "http://88.99.27.54:6012/login";
    private String LOGIN = "operator";
    private String PASSWORD  = "operator";
    WebDriver driver;

    @BeforeClass(description = "Start browser")
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximazed");
        driver = new ChromeDriver(options);
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @Test(description = "login")
    public void login() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);

        WebElement login = driver.findElement(By.id("inputLogin"));
        wait.until(ExpectedConditions.visibilityOf(login));
        login.sendKeys("operator");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys(PASSWORD);
        WebElement authBtn = driver.findElement(By.xpath("//*[text()='Войти']"));
        authBtn.submit();
        WebElement filial = driver.findElement(By.id("selectKitchen"));
        filial.click();
        WebElement filialList = driver.findElement(By.id("selectKitchen"));
        filialList.click();
        WebElement chooseButton = driver.findElement(By.xpath("//*[text()='Выбрать']"));
        chooseButton.click();

    }

    @AfterClass(description = "Stop Browser")
    public void stopBrowser() throws Exception {
        driver.quit();
        System.out.println("Browser was successfully quited.");
    }
}
