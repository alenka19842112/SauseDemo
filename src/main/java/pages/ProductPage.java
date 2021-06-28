package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ProductPage extends HeaderPage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public static final String ADD_PRODUCT_TO_CART_BUTTON = "//*[text()='%s']/ancestor::*[@class='inventory_item']//button";
    public static final By CART_BUTTON = By.xpath("//*[@id='shopping_cart_container']");

    /**
     * add Product To Cart
     *
     * @param productName product Name
     */
    @Step("add Product {productName}To Cart ")
    public ProductPage addProductToCart(String productName) {
        try {
            log.info("productName ="  + productName);
            log.info("click ADD PRODUCT button. Locator:" + ADD_PRODUCT_TO_CART_BUTTON);
            driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
        } catch (Exception e) {
            log.error("Error: Locator ADD PRODUCT button isn't found", e);
        }
        return this;
    }

    /**
     * get Product Page Url
     *
     * @return url "https://www.saucedemo.com/cart.html"
     */
    public String getProductPageUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * click Cart Button
     */
    @Step("click Cart button")
    public void clickCartButton() {
        try {
            log.info("click CART button. Locator:" + CART_BUTTON);
            driver.findElement(CART_BUTTON).click();
        }catch (Exception e){
            log.error("Error: Locator CART button isn't found", e);
        }
    }
}
