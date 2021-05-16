package lesson6.pagesCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BaseView {
    public NavigationMenu navigationMenu;

    public MainPage(WebDriver driver) {
        super(driver);
        navigationMenu = new NavigationMenu(driver);
    }
    @FindBy(xpath = "//a[@title='Geekbrains']")
    public WebElement geekBrainsHomeButton;
    public By geekBrainsHomeButtonLocator=By.xpath("//a[@title='Geekbrains']");

    public void openAllContactPersonsPage(){
        driver.get("https://crm.geekbrains.space/contact/");
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(new AllContact(driver).createContactPersonLocator));
    }
}
