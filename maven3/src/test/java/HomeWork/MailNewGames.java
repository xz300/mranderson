package HomeWork;

import lesson6.pagesMail.AllGames;
import lesson6.pagesMail.AllNewGames;
import lesson6.pagesMail.TomorrowHoroscope;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static lesson6.Configuration.Mail_URL;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;

public class MailNewGames extends BaseTest {
    @BeforeMethod
    void goToPage() {
        driver.get(Mail_URL);
    }
    @Test(description = "Просмотр новых игр", enabled = true)
    void viewNewGame(){
        new AllGames(driver).clickGame.click();
        new AllNewGames(driver).clickNewGame.click();
        List<WebElement> menu = driver.findElements(By.xpath("//*[@class=\"js-text-inner pm-toolbar__button__text__inner  pm-toolbar__button__text__inner_noicon\"]"));
        assertThat(menu.get(0), hasText("Библиотека"));



}


//    @Test(description = "Новые игры Mail", enabled = true)
//    void viewSportsGames() {
//        driver.findElement(By.xpath("//a[text()='Игры']")).click();
//        driver.findElement(By.xpath()).click();

    }