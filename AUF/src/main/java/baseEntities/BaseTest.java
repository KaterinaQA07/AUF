package baseEntities;

import browserService.BrowserService;
import browserService.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.Listener;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    public ReadProperties readProperties = new ReadProperties();

    public BaseTest() {
    }

    @BeforeMethod
    public void setUp() {
        this.driver = new BrowserService().getDriver();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.get(new ReadProperties().getURL());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
