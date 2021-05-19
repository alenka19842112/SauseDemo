package testsFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;
import pagesFactory.CartPageFactory;
import pagesFactory.LoginPageFactory;
import pagesFactory.ProductPageFactory;

import java.util.concurrent.TimeUnit;

public class BaseTestFactory {
    WebDriver driver;
    LoginPageFactory loginPageFactory;
    ProductPageFactory productPageFactory;
    CartPageFactory cartPageFactory;
    @BeforeMethod
    public void initTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginPageFactory = new LoginPageFactory(driver);
        productPageFactory = new ProductPageFactory(driver);
        cartPageFactory = new CartPageFactory(driver);
    }
    @AfterMethod(alwaysRun = true)
    public void endTest(){
        driver.quit();
    }
}
