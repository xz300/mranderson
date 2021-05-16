package HomeWork;

import lesson6.pagesCRM.AllProjects;
import lesson6.pagesCRM.CreateProject;
import lesson6.pagesCRM.CreateRequest;
import lesson6.pagesCRM.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static lesson6.Configuration.LOGIN_URL;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class CrmCreateProject extends BaseTest {

    @BeforeMethod
    void goToPage() {
        driver.get(LOGIN_URL);
    }

    @Test(description = "Создание проекта в CPM системе", enabled = true)
    void addCrmProject() {
        new LoginPage(driver).fillInputLogin("ApplanaTest1")
                .fillInputPassword("Student2020!")
                .submitLogin();
    }

    @Test
    void crateNewProject() throws InterruptedException {
        new LoginPage(driver).login("ApplanaTest1", "Student2020!")
                .navigationMenu.openNavigationMenuItem("Проекты");
        new AllProjects(driver).myProjects.click();
        new CreateRequest(driver).createRequestButton.click();
        new CreateProject(driver)
                .fillOrganization("Организация300")
                .selectBusinessUnit("Research & Development")
                .selectCurator("Ким Юрий")
                .selectPr("Ким Юрий")
                .selectAdmin("Козлов Илья")
                .selectManager("Палкина Анна")
                .chOrganization("Bins-Haley")
                .saveAndCloseButton.click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(new CreateProject(driver).requestSuccessLocator)));
        assertThat(new CreateProject(driver).requestSuccess, isDisplayed());
//тест почему-то опадает на 49 строке
    }
}


