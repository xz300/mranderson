package HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class CrmContactCreate {
    private static WebDriver driver;
    private static final String LOGIN_URL = "https://crm.geekbrains.space/user/login";
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        login();
        Actions actions = new Actions(driver);
        WebElement projectMenu = driver.findElement(By.xpath("//span[text()='Контрагенты']/ancestor::a"));
        actions.moveToElement(projectMenu).perform();
        driver.findElement(By.xpath("//span[text()=\"Контактные лица\"]")).click();
        driver.findElement(By.xpath("//a[text()='Создать контактное лицо']")).click();
        driver.findElement(By.xpath("//*[@name='crm_contact[lastName]']")).sendKeys("Mr.");
        driver.findElement(By.xpath("//*[@name='crm_contact[firstName]']")).sendKeys("Anderson");
        driver.findElement(By.xpath("//*[@name='crm_contact[jobTitle]']")).sendKeys("programmer");
        driver.findElement(By.xpath("//span[text()='Укажите организацию']/..")).click();
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys("Bins-Haley");
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[@class=\"btn btn-success action-button\"]")).click();
        driver.findElement(By.xpath("//*[text()='Контактное лицо сохранено']"));
        driver.quit();
    }
    private static void login() {
        driver.get(LOGIN_URL);
        driver.findElement(By.id("prependedInput")).sendKeys("ApplanaTest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();

    }
}
