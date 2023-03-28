package pageobjects.swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BaseClass {
    By filter = new By.ByXPath("//select[@class='product_sort_container']");
    By pageHeading = new By.ByXPath("//span[contains(text(),'Products')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }
    //apply filter
    public void applyFilter(String value) {
        driver.findElement(filter).click();
        driver.findElement(By.xpath("//select[@class='product_sort_container']/option[@value='" + value + "']")).click();
    }
    //get the filter value
    public String getAppliedFilter() {
        return driver.findElement(By.xpath("//div[@class='right_component']/span/span")).getText();
    }

    public String getPageHeading() {
        return driver.findElement(pageHeading).getText();
    }
    //go to a product detail page
    public void clickOnProductName(String productName){
        driver.findElement(By.xpath(XPATH.getProperty("PRODUCT_NAME_START")+productName+XPATH.getProperty("XPATH_END"))).click();
    }
    //add to cart locator using index
    public WebElement getAddToCart(int index){
        return driver.findElement(By.xpath(XPATH.getProperty("ADD_TO_CART_START")+index+XPATH.getProperty("ADD_TO_CART_END")));
    }
    //add a product to cart
    public void clickOnAddToCart(int index){
        this.getAddToCart(index).click();
    }
    //remove from cart locator using index
    public WebElement getRemoveFromCart(int index){
        return driver.findElement(By.xpath(XPATH.getProperty("REMOVE_FROM_CART_START")+index+XPATH.getProperty("REMOVE_FROM_CART_END")));
    }
    //remove a product from cart
    public void clickOnRemoveFromCart(int index){
        this.getRemoveFromCart(index).click();
    }
}
