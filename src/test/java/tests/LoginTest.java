package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest implements ITestConstans {
    @Test
    public void inputOfCorrectDataTest() {
        loginPage
                .openPage()
                .login(STANDARD_USER_LOGIN, STANDARD_USER_PASSWORD);
        Assert.assertEquals(productPage.getProductPageUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void inputOfEmptyFieldsTest() {
        loginPage
                .openPage()
                .login("", "");
        Assert.assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Username is required");
    }

    @Test
    public void inputOfEmptyPasswordFieldTest() {
        loginPage
                .openPage()
                .login("standard_user", "");
        Assert.assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Password is required");
    }

    @Test
    public void inputOfInCorrectDataTest() {
        loginPage
                .openPage()
                .login("standard_user", "secret");
        Assert.assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Username and password do not match any user in this service");
    }
}
