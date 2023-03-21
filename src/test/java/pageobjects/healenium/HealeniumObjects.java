package pageobjects.healenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HealeniumObjects {
    WebDriver driver;

    public HealeniumObjects(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.xpath("//button[@id='Submit']"));
    }

    public WebElement getByID() {
        return driver.findElement(By.id("change_id"));
    }

    public WebElement getByClassName() {
        return driver.findElement(By.className("test_class"));
    }

    public WebElement getByName() {
        return driver.findElement(By.name("change_name"));
    }

    public WebElement getByLinkText() {
        return driver.findElement(By.linkText("Change: LinkText, PartialLinkText"));
    }

    public WebElement getByTagName() {
        return driver.findElement(By.tagName("test_tag"));
    }

    public WebElement getByXpath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public List<WebElement> getByXpathCheckbox() {
        return driver.findElements(By.xpath("//div[@class='test-form healenium-form validate-form']/div[@class='wrap-input1 validate-input']/input[@type='checkbox']"));
    }

    public WebElement getSubmitButtonCheckbox() {
        return driver.findElement(By.id("Submit_checkbox"));
    }

    public WebElement getByCssSelectorCheckbox(int index) {
        return driver.findElement(By.cssSelector("input#form_checked" + index + ".input1"));
    }

    public boolean clickFirstCheckbox() {
        this.getByCssSelectorCheckbox(1).click();
        return true;
    }
}

