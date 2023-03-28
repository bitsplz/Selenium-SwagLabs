package tests.SwagLabs;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.swaglabs.HomePage;
import pageobjects.swaglabs.LoginPage;
import pageobjects.swaglabs.ProductPage;

public class HomePageTests extends BaseTest{
    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod
    public void beforeEach(){
        driver.get(properties.getProperty("URL"));
        loginPage = new LoginPage(driver);
        loginPage.login(properties.getProperty("username"), properties.getProperty("password"),false);
        homePage = new HomePage(driver);
    }
    @Test(description = "Verify Filter should be applied successfully")
    public void applyFilter(){
        homePage.applyFilter(properties.getProperty("sort_filter"));
        Assert.assertEquals(homePage.getAppliedFilter(), properties.getProperty("sort_filter_text"));
    }
    @Test(description = "Verify product page should be opened successfully")
    public void goToProductPage(){
        homePage.clickOnProductName(properties.getProperty("product_name"));
        ProductPage productPage = new ProductPage(driver);
        Assert.assertEquals(productPage.getProductName(), properties.getProperty("product_name"));
    }
    @Test(description = "Verify product should be added to cart successfully")
    public void addToCart(){
        Assert.assertTrue(homePage.getAddToCart(3).isDisplayed());
        homePage.clickOnAddToCart(3);
        Assert.assertTrue(homePage.getRemoveFromCart(3).isDisplayed());
        Assert.assertEquals(homePage.getCartCount(), 1);
        homePage.clickOnAddToCart(4);
        Assert.assertEquals(homePage.getCartCount(), 2);
        homePage.resetAppState();
    }
    @Test(description = "Verify product should be removed from cart successfully")
    public void removeFromCart(){
        homePage.clickOnAddToCart(3);
        homePage.clickOnAddToCart(2);
        Assert.assertEquals(homePage.getCartCount(), 2);
        homePage.clickOnRemoveFromCart(2);
        Assert.assertEquals(homePage.getCartCount(), 1);
        homePage.resetAppState();
    }
}
