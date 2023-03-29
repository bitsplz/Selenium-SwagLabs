package tests.SwagLabs;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import pageobjects.swaglabs.HomePage;
import pageobjects.swaglabs.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{
    LoginPage loginPage;

    @DataProvider(name="loginCredentials")
    public Object[][] loginCredentials(){
        return new Object[][] {
                {"standard_user", "secret_sauce"},
                {"locked_out_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user","secret_sauce"}
        };
    }

    @BeforeMethod
    public void beforeEach(){
        driver.get(properties.getProperty("URL"));
        loginPage = new LoginPage(driver);
    }
    @Test(dataProvider = "loginCredentials", description = "Verify user should Log in Successfully Clicking button")
    public void login(String username, String password){
        loginPage.login(username, password,false);
        if(username.equalsIgnoreCase("locked_out_user")){
            Assert.assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Sorry, this user has been locked out.");
        }
        else {
            HomePage homePage = new HomePage(driver);
            String login_text = homePage.getPageHeading();
            Assert.assertEquals(login_text, "Products");
        }
    }
    @Test(dataProvider = "loginCredentials", description = "Verify user should Log in Successfully pressing Enter")
    public void loginEnter(String username, String password){
        loginPage.login(username, password,false);
        if(username.equalsIgnoreCase("locked_out_user")){
            Assert.assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Sorry, this user has been locked out.");
        }
        else {
            HomePage homePage = new HomePage(driver);
            String login_text = homePage.getPageHeading();
            Assert.assertEquals(login_text, "Products");
        }
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
