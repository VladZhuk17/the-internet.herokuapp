package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;

public class Inputs {
    /*Проверить на возможность ввести различные цифровые и нецифровые значения,
    используя Keys.ARROW_UP  И Keys.ARROW_DOWN.
    Локатор: By.tagName(“input”) */

    private static final String MAIN_PAGE = "http://the-internet.herokuapp.com/";
    private static final By DROPDOWN_PAGE = By.xpath("//a[@href='/dropdown']");
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
}