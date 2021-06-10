package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest implements ITestConstans{
    @Test(retryAnalyzer = Retry.class,description = "add product to Cart test",priority = 1)
    public void addProductToCartTest() {
        productSteps.loginAndAddProduct(STANDARD_USER_LOGIN, STANDARD_USER_PASSWORD,"Sauce Labs Backpack");
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Backpack"), "$29.99");
    }
}
