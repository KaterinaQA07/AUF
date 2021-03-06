package pagesPF;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPagePF extends BasePage {
    private static String ENDPOINT = "/dashboard";

    protected By addProjectButtonSelector = By.id("sidebar-projects-add");
    protected By bottomProjectLinkSelector = By.linkText("WP_001");

    public DashboardPagePF(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    public boolean isPageOpened() {
        return driver.findElement(By.id("activityChart")).isDisplayed();
    }

    public WebElement getAddProjectButton() {
        return waits.getElementBy(addProjectButtonSelector);
    }

    public WebElement getBottomProjectLink() {
        return waits.getElementBy(bottomProjectLinkSelector);
    }

    public void clickBottomProjectLink() {
        WebElement webElement = getBottomProjectLink();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        //jsExecutor.executeScript("arguments[0].scrollIntoView(true)", webElement);
        jsExecutor.executeScript("arguments[0].click;", webElement);
    }
}


