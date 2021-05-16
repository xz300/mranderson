package HomeWork;

import lesson6.pagesCRM.AllContact;
import lesson6.pagesCRM.CreateContact;
import lesson6.pagesCRM.LoginPage;
import lesson6.pagesCRM.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static lesson6.Configuration.LOGIN_URL;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class CrmContactCreate extends BaseTest {

    @BeforeMethod
    void goToPage() {
        driver.get(LOGIN_URL);
    }

    @Test(description = "Создание контактного лица в CRM", enabled = true)
    void addCrmProject() {
        new LoginPage(driver).fillInputLogin("ApplanaTest1")
                .fillInputPassword("Student2020!")
                .submitLogin();
    }

    @Test(description = "Создание контактного лица в CRM", enabled = true)
    void createContactPerson() throws InterruptedException {
        new LoginPage(driver).login("ApplanaTest1", "Student2020!");
        new MainPage(driver).openAllContactPersonsPage();
        new AllContact(driver).setCreateContact();
        new CreateContact(driver)
                .fillLastName("Mr.")
                .fillFirstName("Anderson")
                .fillOrganization("1234")
                .fillJobTitle("programmer")
                .saveAndCloseButton.click();

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(new CreateContact(driver).requestSuccessLocator)));

        assertThat(new CreateContact(driver).requestSuccess, isDisplayed());
    }


}
