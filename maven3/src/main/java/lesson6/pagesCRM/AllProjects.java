package lesson6.pagesCRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllProjects extends BaseView{
    public AllProjects(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath = "//span[text()='Мои проекты']")
    public WebElement myProjects;
}
