package lesson6.pagesCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateContact extends BaseView {
    public CreateContact(WebDriver driver) {
        super(driver);
    }

    public By createContactPersonLocator = By.name("crm_contact[lastName]");

    @FindBy(name = "crm_contact[lastName]")
    public WebElement lastName;

    public CreateContact fillLastName(String name) {
        lastName.sendKeys(name);
        return this;
    }

    @FindBy(name = "crm_contact[firstName]")
    public WebElement firstName;

    public CreateContact fillFirstName(String name) {
        firstName.sendKeys(name);
        return this;
    }

    @FindBy(xpath = "//span[text()='Укажите организацию']")
    public WebElement indicateOrganization;

    @FindBy(xpath = "//*[@id='select2-drop']/div/input")
    public WebElement inputOrganization;

    public CreateContact fillOrganization(String organization) throws InterruptedException {
        indicateOrganization.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select2-drop']/div/input")));
        inputOrganization.sendKeys(organization);
        Thread.sleep(5000);
        inputOrganization.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(name = "crm_contact[jobTitle]")
    public WebElement jobTitle;

    public CreateContact fillJobTitle(String job) {
        jobTitle.sendKeys(job);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Сохранить и закрыть')]")
    public WebElement saveAndCloseButton;

    @FindBy(xpath = requestSuccessLocator)
    public WebElement requestSuccess;

    public static final String requestSuccessLocator = "//*[text()='Контактное лицо сохранено']";

    public By createProjectPageLocator = By.xpath("//input[@name='crm_project[name]']");
}
