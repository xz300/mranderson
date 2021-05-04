package HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ChangePasswordDiary {
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
        Cookie cookie = new Cookie("PHPSESSID", "fta92jpghv4ep22d2k9h6qsel0");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[@class='i-menu-settings']/..")).click();
        driver.findElement(By.xpath("//*[@id=\"ss_my_changepassword\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"changepassform-password\"]")).sendKeys("123654789");
        driver.findElement(By.xpath("//*[@id=\"new_pass\"]")).sendKeys("1122334455");
        driver.findElement(By.xpath("//*[@id=\"changepassform-repeatpassword\"]")).sendKeys("1122334455");
        driver.findElement(By.xpath("//*[@id=\"form_change_pass_submit\"]")).click();
        driver.quit();
    }
}
