package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest implements ITestConstans {
    @Test(description = "click Cart button test",priority = 1)
    public void clickCartButtonTest() {
        loginSteps.loginInSite(STANDARD_USER_LOGIN,STANDARD_USER_PASSWORD);
        productPage.clickCartButton();
        Assert.assertEquals(cartPage.getCartPageUrl(), SAUSE_DEMO_CART_URL);
    }

    @Test(description = "remove product to Cart test",priority = 1)
    public void removeProductToCartTest() {
        productSteps.loginAndAddProduct(STANDARD_USER_LOGIN, STANDARD_USER_PASSWORD, PRODUCT_NAME);
        cartPage.openPage()
                .removeProductFromCart(PRODUCT_NAME);
        Assert.assertEquals(cartPage.getExistsRemoveButtonsCount(PRODUCT_NAME), 0);
    }
}
