package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Inputs {

    /*Проверить на возможность ввести различные цифровые и нецифровые значения,
    используя Keys.ARROW_UP  И Keys.ARROW_DOWN.
    Локатор: By.tagName(“input”) */

    private final String inputsPage = "http://the-internet.herokuapp.com/inputs";
    private WebDriver driver;
    private final By inputs = By.tagName("input");
    private final String upInput = "1";
    private final String downInput = "-1";
    private final String putNumber = "123";

    @BeforeClass
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

    }

    @Test
    public void checkUpInputTest() {
        driver.get(inputsPage);
        driver.findElement(inputs).sendKeys(Keys.ARROW_UP);
        String ExpectedValue = driver.findElement(inputs).getAttribute("value");
        System.out.println(ExpectedValue);
        Assert.assertEquals(upInput, ExpectedValue);
    }

    @Test
    public void checkDownInputTest() {
        driver.get(inputsPage);
        driver.findElement(inputs).sendKeys(Keys.ARROW_DOWN);
        String ExpectedValue = driver.findElement(inputs).getAttribute("value");
        System.out.println(ExpectedValue);
        Assert.assertEquals(downInput, ExpectedValue);
    }

    @Test
    public void checkNumberInputTest() {
        driver.get(inputsPage);
        driver.findElement(inputs).sendKeys(putNumber);
        String ExpectedValue = driver.findElement(inputs).getAttribute("value");
        Assert.assertEquals(putNumber, ExpectedValue);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}

