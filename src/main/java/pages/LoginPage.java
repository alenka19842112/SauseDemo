package pages;

import Constans.IConstansPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage implements IConstansPage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public static final By USERNAME_INPUT = By.xpath("//*[@data-test='username']");
    public static final By PASSWORD_INPUT = By.xpath("//*[@data-test='password']");
    public static final By LOGIN_BUTTON = By.xpath("//*[@id='login-button']");
    public static final By ERROR_MESSAGE_LOCATOR = By.xpath("//*[contains(@Class, 'error-message-container') and contains(@Class, 'error')]");

    /**
     * login to the page "https://www.saucedemo.com"
     *
     * @param username enter user name
     * @param password enter password
     */
    public ProductPage login(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductPage(driver);
    }

    /**
     * open Page "https://www.saucedemo.com"
     */
    public LoginPage openPage() {
        driver.get(SAUSE_DEMO_BASE_URL);
        return this;
    }

    /**
     * error message when entering invalid data
     *
     * @return text error message
     */
    public String getErrorMessageText() {
        return driver.findElement(ERROR_MESSAGE_LOCATOR).getText();
    }
}
