package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AllertTests extends BaseTest {

    @Test
    public void infoAlertTest() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[. = 'Click for JS Alert']")).click();
        Alert alert = driver.switchTo().alert();

        System.out.println(alert.getText());
        alert.accept();
    }

    @Test
    public void confirmAlertTest() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[. = 'Click for JS Confirm']")).click();
        Alert alert = driver.switchTo().alert();

        System.out.println(alert.getText());
        alert.accept();

        driver.findElement(By.xpath("//button[. = 'Click for JS Confirm']")).click();
        alert = driver.switchTo().alert();
        alert.dismiss();
    }

    @Test
    public void promptAlertTest() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[. = 'Click for JS Prompt']")).click();
        Alert alert = driver.switchTo().alert();

        System.out.println(alert.getText());
        alert.sendKeys("У меня все получилось!!!");
        alert.accept();

        driver.findElement(By.xpath("//button[. = 'Click for JS Prompt']")).click();
        alert = driver.switchTo().alert();
        alert.sendKeys("Ничего не получается!!!");
        alert.dismiss();
    }
}
