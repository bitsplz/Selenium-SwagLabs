package tests.SwagLabs;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.swaglabs.HomePage;
import pageobjects.swaglabs.LoginPage;
import pageobjects.swaglabs.ProductPage;
import java.util.Iterator;
import java.util.Set;

public class CommonTests extends BaseTest{
    LoginPage loginPage;
    @BeforeMethod
    public void beforeEach(){
        driver.get(properties.getProperty("URL"));
        loginPage = new LoginPage(driver);
    }
    @Test(description = "Verify Page titles")
    public void verifyPageTitles(){
        Assert.assertEquals(loginPage.getPageTitle(),properties.getProperty("page_title"));
        loginPage.login(properties.getProperty("username"), properties.getProperty("password"),false);
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.getPageTitle(),properties.getProperty("page_title"));
        homePage.clickOnProductName(properties.getProperty("product_name"));
        ProductPage productPage = new ProductPage(driver);
        Assert.assertEquals(productPage.getPageTitle(),properties.getProperty("page_title"));
    }
    @Test(description = "Verify Page URLs")
    public void verifyPageURL(){
        Assert.assertEquals(loginPage.getPageURL(),properties.getProperty("URL"));
        loginPage.login(properties.getProperty("username"), properties.getProperty("password"),false);
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.getPageURL(),properties.getProperty("home_page_url"));
        homePage.clickOnProductName(properties.getProperty("product_name"));
        ProductPage productPage = new ProductPage(driver);
        String s = productPage.getPageURL();
        Assert.assertEquals(properties.getProperty("product_page_url"), s.substring(0, s.length() - 1));
    }

    @Test(description = "Use Assertion on page source")
    public void verifyPageSourceElement(){
        Assert.assertTrue(loginPage.getPageSource().contains("<meta name=\"description\" content=\"Sauce Labs Swag Labs app\">"));
    }

    @Test(description = "Verify social media links in footer are working")
    public void windowHandle(){
        loginPage.login(properties.getProperty("username"), properties.getProperty("password"),false);
        HomePage homePage = new HomePage(driver);
        // Open 3 child windows
        homePage.goToSocialMedia("facebook");
        homePage.goToSocialMedia("twitter");
        homePage.goToSocialMedia("linkedin");
        //Iterate through the child windows to assert page title
        String mainWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> i1 = allWindows.iterator();
        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            String childPageTitle;
            if (!mainWindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                childPageTitle = driver.getTitle();
                if(childPageTitle.equalsIgnoreCase("twitter.com")){
                    Assert.assertTrue(true);
                } else if (childPageTitle.equalsIgnoreCase("www.facebook.com")) {
                    Assert.assertTrue(true);
                } else if (childPageTitle.equalsIgnoreCase("www.linkedin.com")) {
                    Assert.assertTrue(true);
                }
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
    }
}
