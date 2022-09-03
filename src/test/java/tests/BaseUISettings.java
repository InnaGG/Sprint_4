package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_object.HomePage;

import java.time.Duration;

public abstract class BaseUISettings {
    protected WebDriver driver;
    protected HomePage homePage;

    @Before
    public void setting(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        new WebDriverWait(driver, Duration.ofSeconds(5));
        homePage.clickCookieButton();
        new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
