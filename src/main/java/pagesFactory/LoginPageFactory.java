package pagesFactory;

import Constans.IConstansPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageFactory extends BasePageFactory implements IConstansPage {
    public LoginPageFactory(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@data-test='username']")
    WebElement usernameInput;

    @FindBy(xpath = "//*[@data-test='password']")
    WebElement passwordInput;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(xpath = "//*[contains(@Class, 'error-message-container') and contains(@Class, 'error')]")
    WebElement errorMessageLocator;
    /**
     * login to the page "https://www.saucedemo.com"
     *
     * @param username enter user name
     * @param password enter password
     */
    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
    /**
     * open Page "https://www.saucedemo.com"
     */
    public void openPage() {
        driver.get(SAUSE_DEMO_BASE_URL);
    }
    /**
     * error message when entering invalid data
     *
     * @return text error message
     */
    public String getErrorMessageText() {
        return errorMessageLocator.getText();
    }
}
