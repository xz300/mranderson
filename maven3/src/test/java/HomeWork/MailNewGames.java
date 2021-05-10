package HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;

public class MailNewGames {
    private static WebDriver driver;
    private static final String LOGIN_URL = "https://mail.ru/";

    @BeforeTest
    void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void loginDriver() {
        driver = new ChromeDriver();
        driver.get(LOGIN_URL);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test(description = "Новые игры Mail", enabled = true)
    void viewSportsGames() {
        driver.findElement(By.xpath("//a[text()='Игры']")).click();
        driver.findElement(By.xpath("//a[text()='Новинки']")).click();
        List<WebElement> menu = driver.findElements(By.xpath("//*[@class=\"js-text-inner pm-toolbar__button__text__inner  pm-toolbar__button__text__inner_noicon\"]"));
        assertThat(menu.get(0), hasText("Библиотека"));
    }

    @AfterMethod
    void closedBrowser() {
        driver.quit();
    }
}


