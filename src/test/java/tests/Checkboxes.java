package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/* Проверить, что первый чекбокс unchecked, отметить первый чекбокс, проверить что он checked.
   Проверить, что второй чекбокс checked, сделать uncheck, проверить, что он unchecked.
   Локатор By.cssSelector(“[type=checkbox]”) */

public class Checkboxes {

    private static final String MAIN_PAGE = "http://the-internet.herokuapp.com/";
    public static final By CHECKBOXES_PAGE = By.cssSelector("a[href$=checkboxes]");
    private static final By CHECKBOX_ONE = By.cssSelector("input[type=checkbox]");
    private static final By CHECKBOX_TWO = By.cssSelector("input[type=checkbox]:nth-child(3)");
    private WebDriver driver;
    private boolean actualCheckboxOne;
    private boolean actualCheckboxTwo;
    private boolean expectedCheckboxOne;
    private boolean expectedCheckboxTwo;

    @BeforeClass
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(MAIN_PAGE);
        driver.findElement(CHECKBOXES_PAGE).click();
    }

    @Test(priority = 1)
    public void verifyTheFirstCheckboxIsUncheckedTest() {
        WebElement elementCheckboxOne = driver.findElement(CHECKBOX_ONE);
        actualCheckboxOne = elementCheckboxOne.isSelected();
        expectedCheckboxOne = false;
        Assert.assertEquals(actualCheckboxOne, expectedCheckboxOne);
    }

    @Test(priority = 3)
    public void verifyTheFirstCheckboxIsCheckedTest() {
        driver.findElement(CHECKBOX_ONE).click();
        actualCheckboxOne = driver.findElement(CHECKBOX_ONE).isSelected();
        expectedCheckboxOne = true;
        Assert.assertEquals(actualCheckboxOne, expectedCheckboxOne);
    }

    @Test(priority = 4)
    public void verifyTheSecondCheckboxIsCheckedTest() {
        WebElement elementCheckboxOne = driver.findElement(CHECKBOX_TWO);
        actualCheckboxOne = elementCheckboxOne.isSelected();
        expectedCheckboxOne = true;
        Assert.assertEquals(actualCheckboxOne, expectedCheckboxOne);
    }

    @Test(priority = 6)
    public void verifyTheSecondCheckboxIsUncheckedTest() {
        driver.findElement(CHECKBOX_TWO).click();
        actualCheckboxTwo = driver.findElement(CHECKBOX_ONE).isSelected();
        expectedCheckboxTwo = false;
        Assert.assertEquals(actualCheckboxOne, expectedCheckboxOne);
    }

    @AfterClass
    public void closeBrowserTest() {
        driver.quit();
    }
}