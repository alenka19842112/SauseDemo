package testsFactory;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.ITestConstans;

public class LoginTestFactory extends BaseTestFactory implements ITestConstans {
    @Test
    public void inputOfCorrectDataTest() {
        loginPageFactory.openPage();
        loginPageFactory.login(STANDARD_USER_LOGIN, STANDARD_USER_PASSWORD);
        Assert.assertEquals(productPageFactory.getProductPageUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void inputOfEmptyFieldsTest() {
        loginPageFactory.openPage();
        loginPageFactory.login("", "");
        Assert.assertEquals(loginPageFactory.getErrorMessageText(), "Epic sadface: Username is required");
    }

    @Test
    public void inputOfEmptyPasswordFieldTest() {
        loginPageFactory.openPage();
        loginPageFactory.login("standard_user", "");
        Assert.assertEquals(loginPageFactory.getErrorMessageText(), "Epic sadface: Password is required");
    }

    @Test
    public void inputOfInCorrectDataTest() {
        loginPageFactory.openPage();
        loginPageFactory.login("standard_user", "secret");
        Assert.assertEquals(loginPageFactory.getErrorMessageText(), "Epic sadface: Username and password do not match any user in this service");
    }
}
