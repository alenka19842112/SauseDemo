package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {
    private LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }
    @Step("Login in https://www.saucedemo.com")
    public LoginSteps loginInSite(String username, String password) {
        loginPage
                .openPage()
                .login(System.getProperty("username", username), System.getProperty("password", password));
        return this;
    }
}
