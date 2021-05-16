package lesson6.pagesMail;

import lesson6.pagesCRM.BaseView;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllHoroscope extends BaseView {
    public AllHoroscope(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@class=\"horoscope i-link-no-deco svelte-123mkzr\"]")
    public WebElement clickHoroscope;
//    public By clickHoroscopeLocator = By.xpath("//*[@class=\"horoscope i-link-no-deco svelte-123mkzr\"]");
//    public void setHoroscope() {
//        clickHoroscope.click();
//        webDriverWait.until(
//                ExpectedConditions.presenceOfElementLocated(new CreateContact(driver).createContactPersonLocator));
//    }
}
