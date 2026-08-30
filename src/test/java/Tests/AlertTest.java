package Tests;

import Pages.AlertsPage;
import Pages.CommonPage;
import Pages.HomePage;
import Shared_Data.Test_Base_Page;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AlertTest extends Test_Base_Page {

    @Test
    public void metodaTest(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--user-data-dir=C:\\SeleniumChromeProfile"
        );

//        WebDriver driver = new ChromeDriver(options); //se acceseaza chrome
//        driver.manage().window().maximize(); //maximizeaza fereastra
//        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
//        driver.get("https://demoqa.com/");

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0, 800);"); // 800 pixeli in jos

        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlerts();

        CommonPage commonPage = new CommonPage(getDriver());
        commonPage.clickOnSubMenu("Alerts");

//        List<WebElement> cardList = driver.findElements(By.xpath("//*[@class='category-cards']//*[@data-discover='true']"));
//        cardList.get(2).click();
//
//        List<WebElement> elementsList = driver.findElements(By.xpath("//*[@class='element-list accordion-collapse collapse show']//*[@data-discover='true']"));
//        elementsList.get(1).click();

//        WebElement alertButton = driver.findElement(By.id("alertButton"));
//        WebElement timerAlertButton = driver.findElement(By.id("timerAlertButton"));
//        WebElement confirmButton = driver.findElement(By.id("confirmButton"));
//        WebElement promtButton = driver.findElement(By.id("promtButton"));

//        alertButton.click();
//        Alert alertOk = driver.switchTo().alert();
//        alertOk.accept();

        js.executeScript("window.scrollBy(0, -800);");

        AlertsPage alertsPage = new AlertsPage(getDriver());
        alertsPage.dealWithAlertOk();
        alertsPage.dealWithAlertDelay(5);
        alertsPage.alertConfirm();
        alertsPage.alertPrompt("e ok");


//        timerAlertButton.click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
//        wait.until(ExpectedConditions.alertIsPresent());
//        Alert alert5Seconds = driver.switchTo().alert();
//        alert5Seconds.accept();
//
//        wait.until(ExpectedConditions.elementToBeClickable(confirmButton));
//        confirmButton.click();
//        Alert alertConfirm = driver.switchTo().alert();
//        alertConfirm.dismiss();
//
//        promtButton.click();
//        Alert promtConfirm = driver.switchTo().alert();
//        promtConfirm.sendKeys("ce vrei");
//        promtConfirm.accept();


    }
}
