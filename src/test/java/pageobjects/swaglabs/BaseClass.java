package pageobjects.swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.UtilsConfig;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected final Properties properties;
    protected final Properties XPATH;
    protected final Actions actions;
    protected final By hamburgerMenu = new By.ByXPath("//button[@id='react-burger-menu-btn']");
    protected final By cartCount = new By.ByXPath("//div[@id='shopping_cart_container']/a/span");
    protected final By logoutButton = new By.ByXPath("//a[@id='logout_sidebar_link']");
    protected final By resetAppButton = new By.ByXPath("//a[@id='reset_sidebar_link']");
    protected final By closeMenu = new By.ById("react-burger-cross-btn");
    //social  media links in footer
    private final By facebookLink = new By.ByXPath("//a[contains(text(),'Facebook')]");
    private final By linkedinLink = new By.ByXPath("//a[contains(text(),'LinkedIn')]");
    private final By twitterLink = new By.ByXPath("//a[contains(text(),'Twitter')]");

    public BaseClass(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        this.properties = UtilsConfig.getProperties("SwagLabs");
        this.XPATH = UtilsConfig.getProperties("xpath");
        this.actions = new Actions(driver);
    }
    public String getPageURL(){
        return this.driver.getCurrentUrl();
    }
    public String getPageTitle(){
        return this.driver.getTitle();
    }
    public String getPageSource(){
        return this.driver.getPageSource();
    }

    public void logout(){
        driver.findElement(hamburgerMenu).click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton)).click();
    }

    //count of items in cart
    public int getCartCount(){
        return Integer.parseInt(driver.findElement(cartCount).getText());
    }
    public void resetAppState(){
        driver.findElement(hamburgerMenu).click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(resetAppButton)).click();
        driver.findElement(closeMenu).click();
    }
    public WebElement getFacebookLink(){
        return this.driver.findElement(facebookLink);
    }
    public WebElement getTwitterLink(){
        return this.driver.findElement(twitterLink);
    }
    public WebElement getLinkedinLink(){
        return this.driver.findElement(linkedinLink);
    }
    public void goToSocialMedia(String name){
        if(name.equalsIgnoreCase("twitter")){
            actions.keyDown(Keys.SHIFT).click(this.getTwitterLink()).keyUp(Keys.SHIFT).perform();
        } else if (name.equalsIgnoreCase("facebook")) {
            actions.keyDown(Keys.SHIFT).click(this.getFacebookLink()).keyUp(Keys.SHIFT).perform();
        } else if (name.equalsIgnoreCase("linkedin")) {
            actions.keyDown(Keys.SHIFT).click(this.getLinkedinLink()).keyUp(Keys.SHIFT).perform();
        }
        else {
            System.out.println("Incorrect Social media platform");
        }
    }
    public boolean verifyPageTitle(String title){
        return this.driver.getTitle().equalsIgnoreCase(title);
    }
}

