package lesson6.pagesMail;

import lesson6.pagesCRM.BaseView;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllNewGames extends BaseView {
    public AllNewGames(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[text()='Новинки']")
    public WebElement clickNewGame;
}
