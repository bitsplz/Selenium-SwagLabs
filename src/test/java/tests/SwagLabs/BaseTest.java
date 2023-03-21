package tests.SwagLabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.UtilsConfig;

import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
    protected Properties properties;
    protected Properties XPATH;
    private ChromeOptions options;
    protected WebDriverWait wait;
    @BeforeSuite
    public void setupBeforeSuite(){
        this.options = new ChromeOptions();
        this.options.addArguments("start-maximized");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mujtaba.afzal\\Documents\\ChromeDriver\\chromedriver.exe");
        this.driver = new ChromeDriver(this.options);
        this.properties = UtilsConfig.getProperties("SwagLabs");
        this.XPATH = UtilsConfig.getProperties("xpath");
    }

    @AfterSuite
    public void setupAfterSuite() {
        this.driver.quit();
    }
}
