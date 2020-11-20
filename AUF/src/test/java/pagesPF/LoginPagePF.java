package pagesPF;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wrappers.Button;
import wrappers.UIElement;

public class LoginPagePF extends BasePage {
    private static String ENDPOINT = "/auth/login/";

    @FindBy(id = "name")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "button_primary")
    private WebElement loginButton;

    @FindBy(className = "error-text")
    public WebElement ERROR_MESSAGE_Selector;

    public LoginPagePF(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    public boolean isPageOpened() {
           return loginButton.isDisplayed();
    }

    public DashboardPagePF clickLoginButton() {
        loginButton.click();
        return new DashboardPagePF(driver, false);
    }
}
