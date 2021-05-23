package testsFactory;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.ITestConstans;

public class CartTestFactory extends BaseTestFactory implements ITestConstans {
    @Test
    public void addProductToCartTest() {
        loginPageFactory.openPage();
        loginPageFactory.login(STANDARD_USER_LOGIN, STANDARD_USER_PASSWORD);
        productPageFactory.addProductToCart("Sauce Labs Backpack");
        productPageFactory.addProductToCart("Sauce Labs Bolt T-Shirt");
        cartPageFactory.openPage();
        Assert.assertEquals(cartPageFactory.getProductPrice("Sauce Labs Backpack"), "$29.99");
        Assert.assertEquals(cartPageFactory.getProductPrice("Sauce Labs Bolt T-Shirt"), "$15.99");
    }

    @Test
    public void clickCartButtonTest() {
        loginPageFactory.openPage();
        loginPageFactory.login(STANDARD_USER_LOGIN, STANDARD_USER_PASSWORD);
        productPageFactory.clickCartButton();
        Assert.assertEquals(cartPageFactory.getCartPageUrl(), SAUSE_DEMO_CART_URL);
    }

    @Test
    public void removeProductToCartTest() {
        loginPageFactory.openPage();
        loginPageFactory.login(STANDARD_USER_LOGIN, STANDARD_USER_PASSWORD);
        productPageFactory.addProductToCart("Sauce Labs Bolt T-Shirt");
        cartPageFactory.openPage();
        cartPageFactory.removeProductFromCart("Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(cartPageFactory.getExistsRemoveButtonsCount("Sauce Labs Bolt T-Shirt"), 0);
    }
}
