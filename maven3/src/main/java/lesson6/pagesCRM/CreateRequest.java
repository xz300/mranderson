package lesson6.pagesCRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateRequest extends BaseView{
    public CreateRequest(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[text()='Создать проект']")
    public WebElement createRequestButton;
}
