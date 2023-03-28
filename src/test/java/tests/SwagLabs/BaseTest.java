package tests.SwagLabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import utils.UtilsConfig;

import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
    protected Properties properties;
    protected Properties XPATH;
    protected ChromeOptions options;
    protected SoftAssert softAssert;

    @BeforeClass
    public void setupBeforeTest(){
        this.options = new ChromeOptions();
        this.options.addArguments("start-maximized");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mujtaba.afzal\\Documents\\ChromeDriver\\chromedriver.exe");
        this.driver = new ChromeDriver(this.options);
        this.properties = UtilsConfig.getProperties("SwagLabs");
        this.XPATH = UtilsConfig.getProperties("xpath");
        this.softAssert = new SoftAssert();
    }

    @AfterClass
    public void setupAfterSuite() {
        this.driver.quit();
    }
}
