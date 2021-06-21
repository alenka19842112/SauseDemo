package pages;

import Constans.IConstansPage;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CartPage extends HeaderPage implements IConstansPage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    private static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class='cart_item']";
    private static final String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class='inventory_item_price']";
    private static final String REMOVE_PRODUCT_FROM_CART_BUTTON = "//*[text()='%s']/ancestor::*[@class='cart_item_label']//button";
    public static final By CART_BUTTON = By.xpath("//*[@id='shopping_cart_container']");

    /**
     * open Page "https://www.saucedemo.com/cart.html"
     */
    @Step("open Cart page")
    public CartPage openPage() {
        try {
            log.info("Open Cart page, URL:" + SAUSE_DEMO_CART_URL);
            driver.get(SAUSE_DEMO_CART_URL);
            waitForPageOpened(CART_BUTTON);
        } catch (Exception e) {
            log.fatal(" Fatal error: Cart Page" + SAUSE_DEMO_CART_URL + "not found", e);
        }
        return this;
    }

    /**
     * get Product Price
     *
     * @param productName product Name
     * @return text product price
     */
    public String getProductPrice(String productName) {
        try {
            return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
        } catch (Exception e) {
            log.error("Error in getProductPrice method", e);
            return "";
        }
    }

    /**
     * get Cart Page Url
     *
     * @return url cart page
     */
    public String getCartPageUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * click remove button
     *
     * @param productName product Name
     */
    @Step("remove product from cart")
    public CartPage removeProductFromCart(String productName) {
        try {
            log.info("click REMOVE PRODUCT button. Locator:" + REMOVE_PRODUCT_FROM_CART_BUTTON);
            driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON, productName))).click();
        } catch (Exception e) {
            log.error("Error: REMOVE PRODUCT button is not found",e);
        }
        return this;
    }

    /**
     * checks for the presence of a remove button
     *
     * @param productName product Name
     * @return List(REMOVE_PRODUCT_FROM_CART_BUTTON).size
     */
    public int getExistsRemoveButtonsCount(String productName) {
        return driver.findElements(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON, productName))).size();
    }
}