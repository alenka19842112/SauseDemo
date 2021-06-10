package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest implements ITestConstans {
    @Test(description = "Login with correct data Test", priority = 1)
    public void inputOfCorrectDataTest() {
        loginPage.openPage()
                .login(System.getenv("username"), System.getenv("password"));
        //loginSteps.loginInSite(STANDARD_USER_LOGIN, STANDARD_USER_PASSWORD);
        Assert.assertEquals(productPage.getProductPageUrl(), SAUSE_DEMO_PRODUCT_URL);
    }

    @Test(description = "input of empty fields in Login page Test", priority = 2)
    public void inputOfEmptyFieldsTest() {
        loginSteps.loginInSite("", "");
        Assert.assertEquals(loginPage.getErrorMessageText(), LOGIN_ERROR_MESSAGE_EMPTY_FIELD);
    }

    @Test(description = "input of empty password field in Login page Test", priority = 2)
    public void inputOfEmptyPasswordFieldTest() {
        loginSteps.loginInSite(STANDARD_USER_LOGIN, "");
        Assert.assertEquals(loginPage.getErrorMessageText(), LOGIN_ERROR_MESSAGE_EMPTY_PASSWORD);
    }

    @Test(description = "Login with incorrect data Test", priority = 2)
    public void inputOfInCorrectDataTest() {
        loginSteps.loginInSite(STANDARD_USER_LOGIN, "secret");
        Assert.assertEquals(loginPage.getErrorMessageText(), LOGIN_ERROR_MESSAGE_INCORRECT_DATA);
    }
}
