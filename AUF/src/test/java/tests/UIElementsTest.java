package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.LoginPage;
import steps.LoginSteps;
import wrappers.Table;
import wrappers.UIElement;

public class UIElementsTest extends BaseTest {

    //@Test
    public void initTest() {
        LoginPage loginPage = new LoginPage(driver, true);
        UIElement element = loginPage.getEmailField();
        element.click();

/*
        UIElement loginButton = loginPage.getLoginButton();
        loginButton.click();
*/
    }

    @Test
    public void tableTest() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUsername(), readProperties.getPassword());

        driver.get("https://aqa071.testrail.io/index.php?/admin/projects/overview");

        Table table = new Table(driver, By.cssSelector("table.grid"));
        table.clickItemInRow(1);
    }
}
