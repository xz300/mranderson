package HomeWork;

import lesson6.pagesMail.AllHoroscope;
import lesson6.pagesMail.TomorrowHoroscope;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;


import static lesson6.Configuration.Mail_URL;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;

public class MailViewTheHoroscope extends BaseTest {
    @BeforeMethod
    void goToPage() {
        driver.get(Mail_URL);
    }

    @Test(description = "Просмотр гороскопа на завтра", enabled = true)
    void viewHoroscope(){
        new AllHoroscope(driver).clickHoroscope.click();
        new TomorrowHoroscope(driver).clickButton.click();

        List<WebElement> menu = driver.findElements(By.xpath("//*[@class=\"js-text-inner pm-toolbar__button__text__inner  pm-toolbar__button__text__inner_noicon\"]"));
        assertThat(menu.get(0), hasText("Звезды"));

    }


}


