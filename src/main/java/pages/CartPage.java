package pages;
import Constans.IConstansPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class CartPage extends HeaderPage implements IConstansPage {
    public CartPage(WebDriver driver) {
        super(driver);
    }
    private static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class='cart_item']";
    private static final String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class='inventory_item_price']";
    public static final String REMOVE_PRODUCT_FROM_CART_BUTTON = "//*[text()='%s']/ancestor::*[@class='cart_item_label']//button";
    /**
     * open Page "https://www.saucedemo.com/cart.html"
     */
    public void openPage() {
        driver.get(SAUSE_DEMO_CART_URL);
    }
    /**
     * get Product Price
     * @param productName product Name
     * @return text product price
     */
    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }
    /**
     * get Cart Page Url
     * @return url cart page
     */
    public String getCartPageUrl() {
        return driver.getCurrentUrl();
    }
    /**
     * click remove button
     * @param productName product Name
     */
    public void removeProductFromCart(String productName) {
        driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON, productName))).click();
    }
    /**
     *checks for the presence of a remove button
     * @param productName product Name
     * @return List(REMOVE_PRODUCT_FROM_CART_BUTTON).size
     */
    public int getExistsRemoveButtonsCount(String productName) {
        return driver.findElements(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON, productName))).size();
    }
}