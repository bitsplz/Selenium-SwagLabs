package tests.SwagLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class XpathTests extends BaseTest {
    WebElement element;
    @BeforeMethod
    public void beforeEach() {
        driver.get("http://uitestpractice.com/Students/Form");
    }

    @Test(description = "Use different xpath")
    public void useDifXpath() {
        /** Use of Text() **/
        //verify form heading
        element = getByXpath("//h1[contains(text(),\"User's Application Form\")]");
        softAssert.assertTrue(element.isDisplayed());
        Assert.assertEquals(element.getText(), "User's Application Form");
        /** Using Position **/
        //select a country using position and assert it is selected successfully
        element = getByXpath("//select[@id='sel1']/option[position()=1]");
        softAssert.assertTrue(element.isDisplayed() & element.isEnabled());
        element.click();
        Assert.assertTrue(element.isSelected());
        /** Using Index **/
        //select a country using index and assert it is selected successfully
        element = getByXpath("//select[@id='sel1']/option[1]");
        softAssert.assertTrue(element.isDisplayed() & element.isEnabled());
        element.click();
        Assert.assertTrue(element.isSelected());
        /** Using Preceding **/
        //verify country dropdown is placed before date picker
        Assert.assertTrue(getByXpath("//input[@id='datepicker']//preceding::select[@id='sel1']").isDisplayed());
        /** Using Last  **/
        //select last checkbox option
        element = getByXpath("(//input[@type='checkbox'])[last()]");
        element.click();
        Assert.assertTrue(element.isSelected());
        //select second last radio option
        element = getByXpath("(//input[@type='radio'])[last()-1]");
        element.click();
        Assert.assertTrue(element.isSelected());
        /**- Using AND OR Operator **/
        //chose checkbox option using and with dynamic xpath with variable
        String chkValue = "dance";
        element = getByXpath("//input[@type='checkbox' and @value='"+chkValue+"']");
        element.click();
        Assert.assertTrue(element.isSelected());
        //verify total count of checkboxes and radio options should be 6
        Assert.assertEquals(driver.findElements(By.xpath("//input[@type='checkbox' or @type='radio']")).size(), 6);
    }

    public WebElement getByXpath(String xpath){
        return driver.findElement(By.xpath(xpath));
    }
}
