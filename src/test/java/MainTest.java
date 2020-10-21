import baseIntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import steps.LoginSteps;

import java.util.Objects;

public class MainTest extends BaseTest {
    private LoginSteps loginSteps;



    @Test(groups = )
    public void loginPositiveTest () {
        loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUsername(),readProperties.getPassword());

        Assert.assertTrue(true);


    }@Test(enabled = false)
    public void loginNegativeTest () {
        loginSteps = new LoginSteps(driver);
        loginSteps.login("fail",readProperties.getPassword());

        Assert.assertEquals(new LoginPage(driver, false).get.);
    }
    @DataProvider (name = "набор кредов")
    public Object[][] credentialsFortest() {
        return new Object[][]{
                {"atrostyanko+aqa07@gmail.com", "w3n1bU7F4rxOfnfvrBJL"},
                {"incorrectUsername", "w3n1bU7F4rxOfnfvrBJL"},
                {"atrostyanko+aqa07@gmail.com", "incorrectPsw"},
        };
    }

    @Test (dataProvider = "набор методов")
    public void cLoginWihtMultipleCredentials(String username, String psw){
        loginSteps= new LoginSteps(driver);
        loginSteps.login(username, psw);
    }
    @Parameters ({"username", "psw"})
    @Test
    public void testLoginWithParametrs(@Optional("1") String username, @Optional("2") String psw)) {
        loginSteps = new LoginSteps(driver);
        loginSteps.login();
    }


}

