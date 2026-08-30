package Shared_Data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_Base_Page {
    private WebDriver driver;

    @BeforeMethod

    @Test
    public void initialiseBrowser() {
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
    }

    @AfterMethod
    public void clearBrowser(){
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
