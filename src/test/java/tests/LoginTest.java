package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void inputOfCorrectDataTest() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(productPage.getProductPageUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void inputOfEmptyFieldsTest() {
        loginPage.openPage();
        loginPage.login("", "");
        Assert.assertEquals(loginPage.errorMessagePageLogin(), "Epic sadface: Username is required");
    }

    @Test
    public void inputOfEmptyPasswordFieldTest() {
        loginPage.openPage();
        loginPage.login("standard_user", "");
        Assert.assertEquals(loginPage.errorMessagePageLogin(), "Epic sadface: Password is required");
    }

    @Test
    public void inputOfInCorrectDataTest() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret");
        Assert.assertEquals(loginPage.errorMessagePageLogin(), "Epic sadface: Username and password do not match any user in this service");
    }
}
