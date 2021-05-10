package HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CrmCreateProject {
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
    @Test(description = "Создание проекта в CPM системе", enabled = true)
    void addCrmProject(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//span[text()='Проекты']/ancestor::a"))).build().perform();
        driver.findElement(By.xpath("//span[text()='Мои проекты']")).click();
        driver.findElement(By.xpath("//a[text()='Создать проект']")).click();
        driver.findElement(By.xpath("//span[text()='Укажите организацию']/..")).click();
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys("Bins-Haley");
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[@class=\"select2-container select2\"]/a/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul[2]/li/div")).click();
        Select businessUnit = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        businessUnit.selectByVisibleText("Research & Development");
        Select curator = new Select(driver.findElement(By.name("crm_project[curator]")));
        curator.selectByVisibleText("Ким Юрий");
        Select pr = new Select(driver.findElement(By.name("crm_project[rp]")));
        pr.selectByVisibleText("Ким Юрий");
        Select administrator = new Select(driver.findElement(By.name("crm_project[administrator]")));
        administrator.selectByVisibleText("Козлов Илья");
        Select manager = new Select(driver.findElement(By.name("crm_project[manager]")));
        manager.selectByVisibleText("Палкина Анна");
        driver.findElement(By.name("crm_project[name]")).sendKeys("Anderson022");
        driver.findElement(By.xpath("//*[@class=\"btn btn-success action-button\"]")).click();
        List<WebElement> headers = driver.findElements(By.xpath("//span[@class='filter-items']/div"));
        List<WebElement> menuElements = driver.findElements(By.xpath("//span[@class='grid-header-cell__label']/ancestor::a"));
        assertThat(menuElements.get(0), hasText("НАИМЕНОВАНИЕ"));
        driver.findElement(By.xpath("//*[text()='Проект сохранен']"));


    }


    @AfterMethod
    void closedBrowser(){
        driver.quit();
    }
    private static void login() {
        driver.get(LOGIN_URL);
        driver.findElement(By.id("prependedInput")).sendKeys("ApplanaTest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}
