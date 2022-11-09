package tests;

/* Добавить 2 элемента, удалить элемент, проверить количество элементов
   Локаторы xpath: 1.	By.xpath("//button[text()='Add Element']")
                   2.	By.xpath("//button[text()='Delete']") */

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

import java.util.ArrayList;

public class AddAndRemoveElementsTest {
    private static final String MAIN_PAGE = "http://the-internet.herokuapp.com/";
    private static final By ADD_AND_REMOVE_ELEMENTS = By.xpath("//a[@href='/add_remove_elements/']");
    private static final By ADD_ELEMENT = By.xpath("//button[text()='Add Element']");
    private static final By DELETE_ELEMENT = By.xpath("//button[text()='Delete']");
    private int oneElement = 1;
    private WebDriver driver;

    @BeforeClass
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(MAIN_PAGE);
        driver.findElement(ADD_AND_REMOVE_ELEMENTS).click();
    }

    @Test
    public void verifyAddAndDeleteElementsTest() {
        driver.findElement((ADD_ELEMENT)).click();
        driver.findElement(ADD_ELEMENT).click();
        driver.findElements(DELETE_ELEMENT);
        ArrayList<WebElement> actualElementsList = new ArrayList<>(driver.findElements(ADD_ELEMENT));
        int actualElementsCount = actualElementsList.size();
        Assert.assertEquals(actualElementsCount, oneElement);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}