package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
public class CartTest extends BaseTest implements ITestConstans {
    @Test
    public void addProductToCartTest() {
        loginPage.openPage();
        loginPage.login(STANDARD_USER_LOGIN, STANDARD_USER_PASSWORD);
        productPage.addProductToCart("Sauce Labs Backpack");
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Backpack"), "$29.99");
    }
    @Test
    public void clickCartButtonTest() {
        loginPage.openPage();
        loginPage.login(STANDARD_USER_LOGIN, STANDARD_USER_PASSWORD);
        productPage.clickCartButton();
        Assert.assertEquals(cartPage.getCartPageUrl(), SAUSE_DEMO_CART_URL);
    }
    @Test
    public void removeProductToCartTest() {
        loginPage.openPage();
        loginPage.login(STANDARD_USER_LOGIN, STANDARD_USER_PASSWORD);
        productPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        cartPage.openPage();
        cartPage.removeProductFromCart("Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(cartPage.getExistsRemoveButtonsCount("Sauce Labs Bolt T-Shirt"), 0);
    }
}
