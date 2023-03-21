package pageobjects.swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.xml.xpath.XPath;

public class HomePage extends BaseClass {
    By filter = new By.ByXPath("//select[@class='product_sort_container']");
    By pageHeading = new By.ByXPath("//span[contains(text(),'Products')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void applyFilter(String value) {
        driver.findElement(filter).click();
        driver.findElement(By.xpath("//select[@class='product_sort_container']/option[@value='" + value + "']")).click();
    }

    public String getAppliedFilter() {
        return driver.findElement(By.xpath("//div[@class='right_component']/span/span")).getText();
    }

    public String getPageHeading() {
        return driver.findElement(pageHeading).getText();
    }
    public void clickOnProductName(String productName){
        driver.findElement(By.xpath(XPATH.getProperty("PRODUCT_NAME_START")+productName+XPATH.getProperty("XPATH_END"))).click();
    }
    public WebElement getAddToCart(int index){
        return driver.findElement(By.xpath(XPATH.getProperty("ADD_TO_CART_START")+index+XPATH.getProperty("ADD_TO_CART_END")));
    }
    public void clickOnAddToCart(int index){
        this.getAddToCart(index).click();
    }
    public WebElement getRemoveFromCart(int index){
        return driver.findElement(By.xpath(XPATH.getProperty("REMOVE_FROM_CART_START")+index+XPATH.getProperty("REMOVE_FROM_CART_END")));
    }
    public void clickOnRemoveFromCart(int index){
        this.getRemoveFromCart(index).click();
    }
}
