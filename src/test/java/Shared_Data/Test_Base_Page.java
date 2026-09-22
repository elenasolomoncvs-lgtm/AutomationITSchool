package Shared_Data;
import Logger.LoggerUtility;
import Shared_Data.Browser.Browser_Factory;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;


public class Test_Base_Page {
    private WebDriver driver;
    public String testName;

    @BeforeMethod
    public void initialiseBrowser() {
        ThreadContext.put("testName", this.getClass().getSimpleName());//gaseste numele testului si denumeste numele threadului ca nume al testului
        testName = this.getClass().getSimpleName();
        driver = new Browser_Factory().getBrowserFactory();
        LoggerUtility.infoTestCase("===== The browser started successfully");
        LoggerUtility.startTestCase(testName);
        driver.get("https://demoqa.com/");
    }

    @AfterMethod
    public void clearBrowser(ITestResult result){
        driver.quit();
        LoggerUtility.infoTestCase("The browser was cleard successfully");
        if (result.getStatus() == ITestResult.FAILURE){

            LoggerUtility.errorLog(result.getThrowable().getMessage());
        }
        LoggerUtility.infoTestCase("===== The browser closed successfully");
        LoggerUtility.endTestCase(testName);
    }

    @AfterSuite
    public void finishLogFiles(){
        LoggerUtility.mergeFilesIntoOne();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
