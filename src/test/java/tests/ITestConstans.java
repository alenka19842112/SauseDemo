package tests;

public interface ITestConstans {
    String STANDARD_USER_LOGIN = "standard_user";
    String STANDARD_USER_PASSWORD = "secret_sauce";
    String SAUSE_DEMO_BASE_URL = "https://www.saucedemo.com";
    String SAUSE_DEMO_CART_URL = SAUSE_DEMO_BASE_URL + "/cart.html";
    String SAUSE_DEMO_PRODUCT_URL = SAUSE_DEMO_BASE_URL + "/inventory.html";
    String LOGIN_ERROR_MESSAGE_EMPTY_FIELD = "Epic sadface: Username is required";
    String LOGIN_ERROR_MESSAGE_EMPTY_PASSWORD ="Epic sadface: Password is required";
    String LOGIN_ERROR_MESSAGE_INCORRECT_DATA = "Epic sadface: Username and password do not match any user in this service";
    String PRODUCT_NAME = "Sauce Labs Bolt T-Shirt";
}
