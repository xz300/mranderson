package HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AuthorizationDiary {
    private static WebDriver driver;
    private static final String LOGIN_URL = "https://diary.ru/";

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebDriver driver = new ChromeDriver();
        driver.get(LOGIN_URL);
        Cookie sessionCookie = driver.manage().getCookieNamed("PHPSESSID");
        driver.manage().deleteCookie(sessionCookie);
        Cookie cookie = new Cookie("PHPSESSID", "m8hhedep6imolb5u670vikfrtu");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        driver.quit();
    }
}
