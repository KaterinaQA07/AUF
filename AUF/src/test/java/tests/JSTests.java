package tests;

import baseEntities.BaseTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import steps.LoginSteps;

public class JSTests extends BaseTest {

    @Test
    public void moveToElementTest() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUsername(),
                readProperties.getPassword());

        DashboardPage dashboardPage = new DashboardPage(driver, false);
        dashboardPage.clickBottomProjectLink();
    }
}
