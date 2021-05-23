package pagesFactory;

import Constans.IConstansPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPageFactory extends BasePageFactory implements IConstansPage {
    public ProductPageFactory(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "shopping_cart_container")
    WebElement cartButton;
    public static final String ADD_PRODUCT_TO_CART_BUTTON = "//*[text()='%s']/ancestor::*[@class='inventory_item']//button";

    /**
     * add Product To Cart
     *
     * @param productName product Name
     */
    public void addProductToCart(String productName) {
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
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
    public void clickCartButton() {
        cartButton.click();
    }
}
