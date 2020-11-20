package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import wrappers.Button;
import wrappers.UIElement;

public class LoginPage extends BasePage {
    private static String ENDPOINT = "/auth/login/";

    protected By emailSelector = By.id("name");
    protected By passwordSelector = By.id("password");
    protected By loginSelector = By.id("button_primary");
    protected By ERROR_MESSAGE_Selector = By.className("error-text");

    public LoginPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    public boolean isPageOpened() {
           return waits.isElementDisplayed(By.id("button_primary"));
    }

    public UIElement getEmailField() {
        //return waits.getElementBy(emailSelector);
        new UIElement(driver, emailSelector);
        return new UIElement(driver, emailSelector);
    }

    public WebElement getPasswordField() {
        return waits.getElementBy(passwordSelector);
    }

    public Button getLoginButton() {
        return new Button(driver, loginSelector);
    }

    public String getErrorMessage() {
        return waits.getElementBy(ERROR_MESSAGE_Selector).getText();
    }
}
