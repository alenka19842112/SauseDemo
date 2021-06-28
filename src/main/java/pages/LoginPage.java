package pages;

import Constans.IConstansPage;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
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
    @Step("Fill in {username} and {password} in Login field")
    public ProductPage login(String username, String password) {
        try {
            log.info(String.format("fill in username: '%s' in Login field.", username));
            driver.findElement(USERNAME_INPUT).sendKeys(username);
            log.info(String.format("fill in password: '%s' in Login field.", password));
            driver.findElement(PASSWORD_INPUT).sendKeys(password);
            log.info("click Login button. Locator:" + LOGIN_BUTTON);
            driver.findElement(LOGIN_BUTTON).click();
        } catch (Exception e) {
            log.error("Error login method", e);
        }
        return new ProductPage(driver);
    }

    /**
     * open Page "https://www.saucedemo.com"
     */
    @Step("Open Login page")
    public LoginPage openPage() {
        try {
            log.info("Open Login page, URL:" + SAUSE_DEMO_BASE_URL);
            driver.get(SAUSE_DEMO_BASE_URL);
            waitForPageOpened(LOGIN_BUTTON);
        } catch (Exception e) {
            log.fatal("Fatal error:" + SAUSE_DEMO_BASE_URL + "not found", e);
        }
        return this;
    }

    /**
     * error message when entering invalid data
     *
     * @return text error message
     */
    public String getErrorMessageText() {
        try {
            return driver.findElement(ERROR_MESSAGE_LOCATOR).getText();
        } catch (Exception e) {
            log.error("Error: Locator 'Error message' is not found",e);
            return "";
        }
    }
}
