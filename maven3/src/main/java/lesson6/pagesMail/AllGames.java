package lesson6.pagesMail;

import lesson6.pagesCRM.BaseView;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllGames extends BaseView {
    public AllGames(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[text()='Игры']")
    public WebElement clickGame;
}
