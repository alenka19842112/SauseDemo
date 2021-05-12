package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends HeaderPage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    private static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class='cart_item']";
    private static final String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class='inventory_item_price']";
    public static final String REMOVE_PRODUCT_TO_CART_BUTTON = "//*[text()='%s']/ancestor::*[@class='cart_item_label']//button";

    public void openPage() {
        driver.get("https://www.saucedemo.com/cart.html");
    }

    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }

    public String getCartPageUrl() {
        return driver.getCurrentUrl();
    }

    public void removeProductToCartPage(String productName) {
        driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_TO_CART_BUTTON, productName))).click();
    }

    public int getExistsRemoveButtonsCountOnCartPage(String productName) {
        return driver.findElements(By.xpath(String.format(REMOVE_PRODUCT_TO_CART_BUTTON, productName))).size();
    }
}
