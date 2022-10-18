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

public class Dropdown {
/*   Взять все элементы дроп-дауна и проверить их наличие. Выбрать первый, проверить,
     что он выбран, выбрать второй, проверить, что он выбран.
     Локатор By.id(“dropdown”) */

    private static final String MAIN_PAGE = "http://the-internet.herokuapp.com/";
    private static final By DROPDOWN_PAGE = By.xpath("//a[@href='/dropdown']");
    private static final By DROPDOWN_LIST = By.id("dropdown");
    private By optionOne = By.xpath("//option[@value='1']");
    private By optionTwo = By.xpath("//option[@value='2']");
    private WebDriver driver;

    @BeforeClass
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(MAIN_PAGE);
        driver.findElement(DROPDOWN_PAGE).click();
    }

    @Test
    public void verifyAllDropDownElementsTest() {
        WebElement elementList = driver.findElement((DROPDOWN_LIST));
        String actualElementList = elementList.getText();
        String expectedElementList = "    Please select an option\n" +
                "    Option 1\n" +
                "    Option 2\n" +
                "  ";
        Assert.assertEquals(actualElementList, expectedElementList);
    }

    @Test
    public void pickOptionOne() {
        driver.findElement(DROPDOWN_LIST).click();
        driver.findElement(optionOne).click();
        boolean actualOptionOne = driver.findElement(optionOne).isSelected();
        boolean expectedOptionOne = true;
        Assert.assertEquals(actualOptionOne,expectedOptionOne);
}

    @Test
    public void pickOptionTwo() {
        driver.findElement(DROPDOWN_LIST).click();
        driver.findElement(optionTwo).click();
        boolean actualOptionTwo = driver.findElement(optionTwo).isSelected();
        boolean expectedOptionTwo = true;
        Assert.assertEquals(actualOptionTwo,expectedOptionTwo);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}