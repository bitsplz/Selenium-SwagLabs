package pageobjects.swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BaseClass{
    By username = new By.ById("user-name");
    By password = new By.ByName("password");
    By loginButton = new By.ByClassName("submit-button");

    public LoginPage(WebDriver driver){
        super(driver);
    }
    public void login(String email, String password, Boolean enterKey){
        driver.findElement(this.username).sendKeys(email);
        driver.findElement(this.password).sendKeys(password);
        if(enterKey){
            driver.findElement(loginButton).sendKeys(Keys.ENTER);
        }
        else {
            driver.findElement(loginButton).click();
        }
    }
    public WebElement getErrorMessage(){
        return driver.findElement(By.tagName("h3"));
    }
    public String getErrorMessageText(){
        return driver.findElement(By.tagName("h3")).getText();
    }
}
