package tests.SwagLabs;

import org.testng.annotations.BeforeMethod;
import pageobjects.swaglabs.HomePage;
import pageobjects.swaglabs.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{
    LoginPage loginPage;
    @BeforeMethod
    public void beforeEach(){
        driver.get(properties.getProperty("URL"));
        loginPage = new LoginPage(driver);
    }
    @Test(description = "Verify user should Log in Successfully Clicking button")
    public void login(){
        loginPage.login(properties.getProperty("username"), properties.getProperty("password"),false);
        HomePage homePage = new HomePage(driver);
        String login_text = homePage.getPageHeading();
        Assert.assertEquals(login_text, "Products");
    }
    @Test(description = "Verify user should Log in Successfully pressing Enter")
    public void loginEnter(){
        loginPage.login(properties.getProperty("username"), properties.getProperty("password"), true);
        HomePage homePage = new HomePage(driver);
        String login_text = homePage.getPageHeading();
        Assert.assertEquals(login_text, "Products");
    }
    @Test(description = "Verify user should Log out Successfully", priority = 5)
    public void logout(){
        loginPage.login(properties.getProperty("username"), properties.getProperty("password"),false);
        loginPage.logout();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, properties.getProperty("URL"));
    }
    @Test(description = "Verify user should not Log in with invalid email")
    public void loginInvalidEmail(){
        loginPage.login(properties.getProperty("invalid_username"), properties.getProperty("password"),false);
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(loginPage.getErrorMessageText(), properties.getProperty("invalid_login_error"));
    }
    @Test(description = "Verify user should not Log in with invalid password")
    public void loginInvalidPassword(){
        loginPage.login(properties.getProperty("username"), properties.getProperty("invalid_password"),true);
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(loginPage.getErrorMessageText(), properties.getProperty("invalid_login_error"));
    }
}
