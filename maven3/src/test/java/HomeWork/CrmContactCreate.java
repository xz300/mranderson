package HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CrmContactCreate {

    private static WebDriver driver;
    private static final String LOGIN_URL = "https://crm.geekbrains.space/user/login";

    @BeforeTest
    void setUp(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    void loginDriver(){
        driver = new ChromeDriver();
        driver.get(LOGIN_URL);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        login();
    }
    @Test(description = "Создание контакта в CPM системе", enabled = true)
    void addCrmContact(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//span[text()='Контрагенты']/ancestor::a"))).build().perform();
        driver.findElement(By.xpath("//span[text()=\"Контактные лица\"]")).click();
        driver.findElement(By.xpath("//a[text()='Создать контактное лицо']")).click();
        driver.findElement(By.xpath("//*[@name='crm_contact[lastName]']")).sendKeys("Mr.");
        driver.findElement(By.xpath("//*[@name='crm_contact[firstName]']")).sendKeys("Anderson");
        driver.findElement(By.xpath("//*[@name='crm_contact[jobTitle]']")).sendKeys("programmer");
        driver.findElement(By.xpath("//span[text()='Укажите организацию']/..")).click();
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys("Bins-Haley");
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[@class=\"btn btn-success action-button\"]")).click();


        List<WebElement> headers = driver.findElements(By.xpath("//span[@class='filter-items']/div"));
        assertThat(headers.get(0), hasText("ФИО: Все"));
        driver.findElement(By.xpath("//*[text()='Контактное лицо сохранено']"));

    }
    @AfterMethod
    void closedBrowser(){
        driver.quit();
    }

    private static void login() {
        driver.findElement(By.id("prependedInput")).sendKeys("ApplanaTest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();

    }
}
