package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends HeaderPage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public static final String ADD_PRODUCT_TO_CART_BUTTON = "//*[text()='%s']/ancestor::*[@class='inventory_item']//button";
    public static final By CART_BUTTON = By.xpath("//*[@id='shopping_cart_container']");

    public void addProductToCart(String productName) {
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
    }

    public String getProductPageUrl() {
        return driver.getCurrentUrl();
    }

    public void clickCartButton() {
        driver.findElement(CART_BUTTON).click();
    }
}
