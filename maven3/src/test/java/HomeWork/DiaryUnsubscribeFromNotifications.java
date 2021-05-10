package HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;

public class DiaryUnsubscribeFromNotifications {
    private static WebDriver driver;
    private static final String LOGIN_URL = "https://diary.ru/";

    @BeforeTest
    void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @Test(description = "Логин на сайт, отписка от уведомлений", enabled = true)
    void logIn()  {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(LOGIN_URL);
        Cookie sessionCookie = driver.manage().getCookieNamed("PHPSESSID");
        driver.manage().deleteCookie(sessionCookie);
        Cookie cookie = new Cookie("PHPSESSID", "ducevu9qupqm171qeoo774ug0t");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();

        driver.findElement(By.xpath("//*[@id=\"discussionLink\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"unsubs_all\"]")).click();
        driver.findElement(By.xpath("//*[text()='Успешно']"));
        List<WebElement> headers = driver.findElements(By.xpath("//*[@id=\"w1\"]/li"));
        assertThat(headers.get(0), hasText("Почтовые уведомления"));

}

    @AfterMethod
    void closedBrowser() {
        driver.quit();
    }
}


//        driver.findElement(By.name("BlogsPosts[title]")).sendKeys("New post");
//        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'message_ifr')]")));
//        driver.findElement(By.xpath("//body")).sendKeys("My new post");
//        driver.switchTo().defaultContent();
//        driver.findElement(By.xpath("//input[contains(@name,'rewrite')]")).click();
//        driver.findElement(By.xpath("//*[@class='i-menu-settings']/..")).click();
//        driver.findElement(By.xpath("//*[@id=\"ss_my_changepassword\"]/a")).click();
//        driver.findElement(By.xpath("//*[@id=\"changepassform-password\"]")).sendKeys("123654789");
//        driver.findElement(By.xpath("//*[@id=\"new_pass\"]")).sendKeys("987456321");
//        driver.findElement(By.xpath("//*[@id=\"changepassform-repeatpassword\"]")).sendKeys("987456321");
//        driver.findElement(By.xpath("//*[@id=\"form_change_pass_submit\"]")).click();
//        WebElement settingsMenu = driver.findElement(By.xpath("//*[@id=\"ss_my_geography\"]"));
//        WebElement settingsMenu = driver.findElement(By.xpath("//*[@id=\"ss_my_geography\"]/a"));
//        String backgroundColor = gridRow.getCssValue("background-color");
//        assertThat(settingsMenu, hasText("Место жительства, временной пояс"));

//        List<WebElement> big = driver.findElements(By.xpath("//*[@id=\"ss_my_geography\"]"));
//        assertThat(big.get(0), hasText("Место жительства, временной пояс"));
//        driver.findElement(By.xpath("//*[@class=\"username\"]"));