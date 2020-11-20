package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import steps.LoginSteps;
import utils.Retry;

public class MainTest1 extends BaseTest {
    private LoginSteps loginSteps;

    @Test (priority = 1)
    public void loginPositiveTest() {
        loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUsername(),
                readProperties.getPassword());

        Assert.assertTrue(false);
    }

    @Test(priority = 2)
    public void loginNegativeTest() {
        loginSteps = new LoginSteps(driver);
        loginSteps.login("fail",
                readProperties.getPassword());

        Assert.assertEquals(new LoginPage(driver, false).getErrorMessage(),
                "Email/Login or Password is incorrect. Please try again.",
                "Incorrect error message.");
    }

    @DataProvider(name = "набора кредов")
    public Object[][] credentialsForTest() {
            return new Object[][] {
                    {"atrostyanko+aqa07@gmail.com", "w3n1bU7F4rxOfnfvrBJL"},
                    {"incorrectUsername", "w3n1bU7F4rxOfnfvrBJL"},
                    {"atrostyanko+aqa07@gmail.com", "incorrectPsw"},
            };
    }

    @Test(dataProvider = "набора кредов")
    public void testLoginWithMultipleCredentials(String username, String psw) {
        loginSteps = new LoginSteps(driver);
        loginSteps.login(username, psw);
    }

    @Parameters({"username", "psw"})
    @Test
    public void testLoginWithParameters(@Optional("afsfsa") String username, @Optional("2") String psw) {
        loginSteps = new LoginSteps(driver);
        loginSteps.login(username, psw);
    }

    @Test(retryAnalyzer = Retry.class)
    public void retryTest() {
        throw new NullPointerException();
    }
}
