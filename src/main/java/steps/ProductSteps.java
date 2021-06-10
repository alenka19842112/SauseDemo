package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductPage;

public class ProductSteps {
    private LoginPage loginPage;
    private ProductPage productsPage;

    public ProductSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        productsPage = new ProductPage(driver);
    }

    @Step("Login and add product to cart")
    public ProductSteps loginAndAddProduct(String username, String password, String productName) {
        loginPage
                .openPage()
                .login(System.getProperty("username", username), System.getProperty("password", password))
                .addProductToCart(productName);
        return this;
    }
}

