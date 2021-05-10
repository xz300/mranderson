package HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;

public class DiaryAuthorizationLogin {
    private static WebDriver driver;
    private static final String LOGIN_URL = "https://diary.ru/";

    @BeforeTest
    void setUp(){
        WebDriverManager.chromedriver().setup();
    }
    @Test
    void logIn(){
        driver = new ChromeDriver();
        driver.get(LOGIN_URL);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Cookie sessionCookie = driver.manage().getCookieNamed("PHPSESSID");
        driver.manage().deleteCookie(sessionCookie);
        Cookie cookie = new Cookie("PHPSESSID", "tk7muahpj1tmqn9sdsiocmhvg6");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();

        List<WebElement> headers = driver.findElements(By.xpath("//*[@class=\"username\"]"));
        assertThat(headers.get(0), hasText("xz300"));
        driver.findElement(By.xpath("//*[@class=\"username\"]"));

     }
    @AfterMethod
    void closedBrowser(){
        driver.quit();
    }
}