package tests;

import baseEntities.BaseTest;
import models.Account;
import models.Project;
import models.ProjectBuilder;
import models.User;
import org.testng.annotations.Test;
import steps.AdministrationStep;
import steps.LoginSteps;

public class PageFactoryTest extends BaseTest {

    @Test
    public void firstTest() {
        User user = new User(readProperties.getUsername(), readProperties.getPassword());

        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(user);

        Project project = new Project("Main Project", "Какое описание", true, 1, false );

        ProjectBuilder projectBuilder = ProjectBuilder.newBuilder()
                .setName("")
                .setAnnouncement("")
                .build();

        Account account = Account.newBuilder()
                .setToken("hello")
                .setUserId("habr")
                .build();

        AdministrationStep administrationStep = new AdministrationStep();
        administrationStep.updateProject(project);
    }
}
