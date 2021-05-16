package lesson6.pagesMail;

import lesson6.pagesCRM.BaseView;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TomorrowHoroscope extends BaseView {
    public TomorrowHoroscope(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[text()=\"Завтра\"]")
    public WebElement clickButton;
}

