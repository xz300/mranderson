package lesson6.pagesCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreateProject extends BaseView{
    public CreateProject(WebDriver driver) {
        super(driver);
    }
    @FindBy (name = "crm_project[name]" )
    public WebElement nameOrganization;

    public  CreateProject fillOrganization(String organization){
        nameOrganization.sendKeys(organization);
        return this;
    }
    @FindBy (name = "crm_project[businessUnit]" )
    public WebElement businessUnitSelect;
    public  CreateProject selectBusinessUnit(String businessUnit){
        new Select(businessUnitSelect).selectByVisibleText(businessUnit);
        return this;
    }
    @FindBy (name = "crm_project[curator]" )
    public WebElement curatorSelect;
    public  CreateProject selectCurator(String curatorName){
        new Select(curatorSelect).selectByVisibleText(curatorName);
        return this;
    }

    @FindBy (name = "crm_project[rp]" )
    public WebElement prSelect;
    public  CreateProject selectPr(String prName){
        new Select(prSelect).selectByVisibleText(prName);
        return this;
    }
    @FindBy (name = "crm_project[administrator]" )
    public WebElement adminSelect;
    public  CreateProject selectAdmin(String adminName){
        new Select(adminSelect).selectByVisibleText(adminName);
        return this;
    }
    @FindBy (name = "crm_project[manager]" )
    public WebElement managerSelect;
    public  CreateProject selectManager(String managerName){
        new Select(managerSelect).selectByVisibleText(managerName);
        return this;
    }
    @FindBy(xpath = "//span[text()='Укажите организацию']")
    public WebElement indicateOrganization;

    @FindBy(xpath = "//*[@id='select2-drop']/div/input")
    public WebElement inputOrganization;

    public CreateProject chOrganization(String organization) throws InterruptedException {
        indicateOrganization.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select2-drop']/div/input")));
        inputOrganization.sendKeys(organization);
        Thread.sleep(5000);
        inputOrganization.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Сохранить и закрыть')]")
    public WebElement saveAndCloseButton;

    @FindBy(xpath = requestSuccessLocator)
    public WebElement requestSuccess;

    public static final String requestSuccessLocator = "//*[text()='Проект сохранен']";

}
