package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
    @Test
    public void addProductToCartTest() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productPage.addProductToCart("Sauce Labs Backpack");
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Backpack"), "$29.99");
    }

    @Test
    public void clickCartButtonTest() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productPage.clickCartButton();
        Assert.assertEquals(cartPage.getCartPageUrl(), "https://www.saucedemo.com/cart.html");
    }

    @Test
    public void removeProductToCartTest() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productPage.addProductToCart("Sauce Labs Backpack");
        productPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        cartPage.openPage();
        cartPage.removeProductToCartPage("Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(cartPage.getExistsRemoveButtonsCountOnCartPage("Sauce Labs Bolt T-Shirt"), 0);
    }
}
