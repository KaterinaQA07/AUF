package browserService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class BrowserService {
    private WebDriver driver = null;
    public BrowserService() {
            String browserName = new ReadProperties().getBrowserName();

        switch (browserName.toLowerCase()){
            case "chrome":
                ClassLoader classLoader = getClass().getClassLoader();
                File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
                String absolutePath = file.getAbsolutePath();
                System.setProperty("webdriver.chrome.driver", absolutePath);

                /*System.setProperty("webdriver.chrome.driver",
                        "C:/Users/VVV/Desktop/Уроки/repo/Project-1/chromedriver.exe");*/

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--start-maximizer");
                chromeOptions.setHeadless(false);

                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
                break;

            case "firefox":
                classLoader = getClass().getClassLoader();
                file = new File(classLoader.getResource("drivers/geckodriver.exe").getFile());
                absolutePath = file.getAbsolutePath();

                System.setProperty("webdriver.gecko.driver", absolutePath);
                driver = new FirefoxDriver();
                break;

            case "ie":
                break;

            case "edge":
                classLoader = getClass().getClassLoader();
                file = new File(classLoader.getResource("drivers/gmsedgedriver.exe").getFile());
                absolutePath = file.getAbsolutePath();

                System.setProperty("webdriver..driver", absolutePath);
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Browser is not support");
                break;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
