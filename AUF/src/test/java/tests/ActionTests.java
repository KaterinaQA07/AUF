package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.DashboardPage;
import steps.LoginSteps;
import utils.Waits;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ActionTests extends BaseTest {

    //@Test
    public void clickBottomLink() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUsername(),
                readProperties.getPassword());

        DashboardPage dashboardPage = new DashboardPage(driver, false);
        dashboardPage.clickBottomProjectLink();
    }

    //@Test
    public void dragAndDropTest() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUsername(),
                readProperties.getPassword());

        driver.get("https://aqa071.testrail.io/index.php?/cases/edit/1/1");

        WebElement icon = driver.findElement(By.className("icon-markdown-image"));

        icon.click();

        WebElement dialogField = driver.findElement(By.id("attachmentDropzone"));
        dialogField.sendKeys("/Users/aleksandr.trostyanko/Downloads/2020-11-04_14-11-54.jpg");

        WebElement attachmentSubmit = driver.findElement(By.id("attachmentSubmit"));
        attachmentSubmit.submit();
    }

    @Test
    public void uploadTest() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/upload");

        WebElement uploadInput = driver.findElement(By.xpath("//input[@type='file']"));
        uploadInput.sendKeys("/Users/aleksandr.trostyanko/Downloads/2020-11-04_14-11-54.jpg");

        driver.findElement(By.id("file-submit")).click();
    }
}
