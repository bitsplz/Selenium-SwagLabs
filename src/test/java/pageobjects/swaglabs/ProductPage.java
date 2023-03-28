package pageobjects.swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class ProductPage extends BaseClass{
    private final By productNameXpath = new By.ByXPath("//div[@class='inventory_details_name large_size']");
    private final By addToCartButton = new By.ByXPath("//button[@class='btn btn_primary btn_small btn_inventory']");
    private final By removeFromCartButton = new By.ByXPath("//button[@class='btn btn_secondary btn_small btn_inventory']");
    private final By productPrice = new By.ByClassName("inventory_details_price");

    public ProductPage(WebDriver driver) {
        super(driver);
    }
    public String getProductName(){
        return driver.findElement(productNameXpath).getText();
    }
    public WebElement getAddToCartButton(){
        return driver.findElement(addToCartButton);
    }
    public WebElement getRemoveFromCartButton(){
        return driver.findElement(removeFromCartButton);
    }
    public String getProductPrice(){
        String price = driver.findElement(productPrice).getText();
        return price.substring(1);
    }
    public List<WebElement> getCartCountList(){
        return driver.findElements(cartCount);
    }
}
