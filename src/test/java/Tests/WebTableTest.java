package Tests;

import ObjectData.TextBoxObject;
import ObjectData.WebTableObject;
import Pages.CommonPage;
import Pages.HomePage;
import Pages.WebTablePage;
import Shared_Data.Test_Base_Page;
import XmlReader.XmlDataLoader;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Map;
@Listeners(ChainTestListener.class)
public class WebTableTest extends Test_Base_Page {

    private Map<String, WebTableObject> webTableObjectMap;

    @Test
    public void metodaTest() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--user-data-dir=C:\\SeleniumChromeProfile"
        );

        webTableObjectMap = XmlDataLoader.loadData("C:\\Users\\ASOC PROP Nr.13\\Desktop\\Proiect individual\\Automation_Sesiunea_1\\src\\test\\resources\\WebTableData.xml", WebTableObject.class);
        WebTableObject data = webTableObjectMap.get("dataSet_1");
        WebTableObject data2 = webTableObjectMap.get("dataSet_2");

        Thread.sleep(2000); // metoda Wait (pauza) daca codul ruleaza prea rapid - (2sec)

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0, 800);"); // 800 pixeli în jos

        HomePage homePage = new HomePage(getDriver());
        homePage.clickElements();



        js.executeScript("window.scrollBy(0, -800);");

        Thread.sleep(2000); //metoda wait de 2 secunde (nu prea se foloseste pt ca poate strica ceva in spate)

        ChainTestListener.log("The user clicked on elements");

        CommonPage commonPage = new CommonPage(getDriver());
        commonPage.clickOnSubMenu("Web Tables");

        ChainTestListener.log("The user clicked on submenu");

        Thread.sleep(2000);

        WebTablePage webTablePage = new WebTablePage(getDriver());

        webTablePage.addEntry(data);
        ChainTestListener.log("The user added an full entry");

        webTablePage.addEntry(data2);

        ChainTestListener.log("The user added an full entry");

        WebElement rowAdded = getDriver().findElement(By.xpath("(//tr)[5]"));
        String rowAddedText = rowAdded.getText();
        System.out.println(rowAddedText);

        js.executeScript("window.scrollBy(0, -800);");

        webTablePage.verifyEntry(data);
        ChainTestListener.log("All entries were verified");
//        ChainTestListener.embed(bytes, "image/png"); vezi rezolvare la aceasta linie. trebuie pus in metoda de clearBrowser!

    }
}
