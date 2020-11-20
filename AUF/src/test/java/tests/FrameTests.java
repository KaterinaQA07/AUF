package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FrameTests extends BaseTest {

    @Test
    public void frameTest() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/iframe");

        //driver.switchTo().frame(0);
        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        System.out.println(driver.findElement(By.tagName("p")).getText());
        Assert.assertTrue(driver.findElement(By.id("tinymce")).isDisplayed());
        driver.switchTo().parentFrame();
    }
}
