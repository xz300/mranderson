package lesson6.pagesCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllContact extends BaseView {
    public AllContact(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div/a[contains(text(),'Создать контактное лицо')]")
    public WebElement createContactPerson;

    public By createContactPersonLocator = By.xpath("//div/a[contains(text(),'Создать контактное лицо')]");

    public void setCreateContact() {
        createContactPerson.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(new CreateContact(driver).createContactPersonLocator));
    }
}
