package tests.SwagLabs;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.swaglabs.HomePage;
import pageobjects.swaglabs.LoginPage;
import pageobjects.swaglabs.ProductPage;

public class ProductPageTests extends BaseTest{
    HomePage homePage;
    LoginPage loginPage;
    ProductPage productPage;
    @BeforeMethod
    public void beforeEach(){
        driver.get(properties.getProperty("URL"));
        loginPage = new LoginPage(driver);
        loginPage.login(properties.getProperty("username"), properties.getProperty("password"),false);
        homePage = new HomePage(driver);
        homePage.clickOnProductName(properties.getProperty("product_name"));
        productPage = new ProductPage(driver);
    }
    @Test(description = "Case 1: Verify add to cart should work on product page successfully")
    public void addToCartProductPage() {
        productPage.getAddToCartButton().click();
        Assert.assertEquals(homePage.getCartCountText(), "1");
        productPage.resetAppState();
    }
    @Test(description = "Case 2: Verify remove from cart should work on product page successfully")
    public void removeFromCartProductPage() {
        productPage.getAddToCartButton().click();
        Assert.assertEquals(homePage.getCartCountText(), "1");
        productPage.getRemoveFromCartButton().click();
        Assert.assertTrue(productPage.getCartCount().size()==0);
    }
}
