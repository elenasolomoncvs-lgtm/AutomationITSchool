package Tests;

import ObjectData.TextBoxObject;
import ObjectData.WebTableObject;
import Pages.CommonPage;
import Pages.HomePage;
import Pages.WebTablePage;
import Shared_Data.Test_Base_Page;
import XmlReader.XmlDataLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.Map;

public class WebTableTest extends Test_Base_Page {

    private Map<String, TextBoxObject> webTableObjectMap;
    @Test
    public void metodaTest() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--user-data-dir=C:\\SeleniumChromeProfile"
        );

        webTableObjectMap = XmlDataLoader.loadData("C:\\Users\\ASOC PROP Nr.13\\Desktop\\Proiect individual\\Automation_Sesiunea_1\\src\\test\\resources\\WebTableData.xml", WebTableObject.class);
        TextBoxObject data = webTableObjectMap.get("dataSet_1");

//        String firstName = "Elena";
//        String lastName = "Solomon";
//        String age = "25";
//        String userEmail = "abc@ncid.net";
//        String salary = "1000";
//        String department = "IT test";

        Thread.sleep(2000); // metoda Wait (pauza) daca codul ruleaza prea rapid - (2sec)

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0, 800);"); // 800 pixeli în jos

        HomePage homePage = new HomePage(getDriver());
        homePage.clickElements();

        js.executeScript("window.scrollBy(0, -800);");


        Thread.sleep(2000);

        CommonPage commonPage = new CommonPage(getDriver());
        commonPage.clickOnSubMenu("Web Tables");

        Thread.sleep(2000);

        WebTablePage webTablePage = new WebTablePage(getDriver());

        webTablePage.addEntry(firstName, lastName, userEmail, age, salary, department);
        webTablePage.addEntry("John", "Doe", "abc@gmail.com", "45", "15000", "IT");

        WebElement rowAdded = getDriver().findElement(By.xpath("(//tr)[5]"));
        String rowAddedText = rowAdded.getText();
        System.out.println(rowAddedText);

        js.executeScript("window.scrollBy(0, -800);");

        webTablePage.verifyEntry(firstName,lastName,userEmail,age, salary, department);

    }
}
