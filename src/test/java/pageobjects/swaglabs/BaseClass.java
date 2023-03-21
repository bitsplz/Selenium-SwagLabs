package pageobjects.swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.UtilsConfig;

import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Properties properties;
    protected Properties XPATH;
    protected By hamburgerMenu = new By.ByXPath("//button[@id='react-burger-menu-btn']");
    protected By cartCount = new By.ByXPath("//div[@id='shopping_cart_container']/a/span");
    protected By logoutButton = new By.ByXPath("//a[@id='logout_sidebar_link']");
    protected By resetAppButton = new By.ByXPath("//a[@id='reset_sidebar_link']");
    protected By closeMenu = new By.ById("react-burger-cross-btn");

    public BaseClass(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        this.properties = UtilsConfig.getProperties("SwagLabs");
        this.XPATH = UtilsConfig.getProperties("xpath");
    }
    public String getPageURL(){
        return this.driver.getCurrentUrl();
    }
    public void printPageTitle(){
        System.out.println("Page Title: "+this.driver.getTitle());
    }
    public void logout(){
        driver.findElement(hamburgerMenu).click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton)).click();
    }
    public WebElement getCartIcon(){
        return driver.findElement(By.id("shopping_cart_container"));
    }
    private WebElement getCartCount(){
        return driver.findElement(cartCount);
    }
    public String getCartCountText(){
        return this.getCartCount().getText();
    }
    public void resetAppState(){
        driver.findElement(hamburgerMenu).click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(resetAppButton)).click();
        driver.findElement(closeMenu).click();
    }
}

