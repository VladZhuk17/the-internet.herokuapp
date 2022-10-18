package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

  /* Typos - Проверить соответствие параграфа орфографии
     Локатор: By.tagName(“p”) */

public class Typos {

    private static final String MAIN_PAGE = "http://the-internet.herokuapp.com/";
    private static final By TYPOS_PAGE = By.xpath("//a[@href='/typos']");
    private static final By theText = By.xpath ("//*[contains(text(), 'Sometimes you')]");
    private String text =  "Sometimes you'll see a typo, other times you won't.";;
    private WebDriver driver;


    @BeforeClass
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(MAIN_PAGE);
        driver.findElement(TYPOS_PAGE).click();
    }

    @Test
    public void verifyCorrectTypoTextTest() {
        String actualText = driver.findElement(theText).getText();
        Assert.assertEquals(actualText, text);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}