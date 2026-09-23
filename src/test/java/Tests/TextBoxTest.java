package Tests;

import ObjectData.TextBoxObject;
import Pages.CommonPage;
import Pages.HomePage;
import Pages.TextBoxPage;
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


import java.util.List;
import java.util.Map;
@Listeners(ChainTestListener.class)
public class TextBoxTest {

    private Object userNameField;

    private Map<String, TextBoxObject> textBoxObjectMap;

    @Test
    public void metodaTest() throws InterruptedException {

        textBoxObjectMap = XmlDataLoader.loadData("src/test/resources/TextBoxData.xml", TextBoxObject.class);
        TextBoxObject data = textBoxObjectMap.get("dataSet_1");

        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--user-data-dir=C:\\SeleniumChromeProfile"
        );

        WebDriver driver = new ChromeDriver(options); //se acceseaza chrome
        driver.manage().window().maximize(); //maximizeaza fereastra
        driver.get("https://demoqa.com/");

        String fullName = "Elena";
        String userEmail = "elena.solomoncvs@gmail.com";
        String currectAddress = "Tg Mures";
        String permanentAddress = "Onesti";

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 800);"); // 800 pixeli in jos
        //[@class='category-cards']//[@data-discover='true']

//        List<WebElement> cardList = driver.findElements(By.xpath("//*[@class='category-cards']//*[@data-discover='true']"));
//        cardList.get(0).click();

//        List<WebElement> elementsList = driver.findElements(By.xpath("//*[@class='element-list accordion-collapse collapse show']//*[@data-discover='true']"));
//        elementsList.get(0).click();

        HomePage homePage = new HomePage(driver);
        homePage.clickElementsWithJavaScript();

        js.executeScript("window.scrollBy(0, -800);"); // 800 pixeli in jos

        CommonPage commonPage = new CommonPage(driver);
        commonPage.clickOnSubMenu("Text Box");

        TextBoxPage textBoxPage = new TextBoxPage(driver);
        textBoxPage.addNewEntry(fullName, userEmail, currectAddress, permanentAddress);


//        WebElement firstNameColum = driver.findElement(By.id("userName"));
//        WebElement userEmailColum = driver.findElement(By.id("userEmail"));
//        WebElement currentAdressColum = driver.findElement(By.id("currentAddress"));
//        WebElement permanentAdressColum = driver.findElement(By.id("permanentAddress"));

//        firstNameColum.sendKeys("Elena");
//        userEmailColum.sendKeys("elena.solomoncvs@gmail.com");
//        currentAdressColum.sendKeys("Tg Mures");
//        permanentAdressColum.sendKeys("Onesti");

//        WebElement submitButton = driver.findElement(By.id("submit"));
//        submitButton.click();

        WebElement name = driver.findElement(By.id("name"));
        assert name.getText().equals("Name:Elena");

        WebElement email = driver.findElement(By.id("email"));
        assert email.getText().equals("Email:elena.solomoncvs@gmail.com");

        List<WebElement> infoList = driver.findElements(By.xpath("//*[@class='mb-1']"));
        assert infoList.get(2).getText().equals("Current Address :Tg Mures");
        assert infoList.get(3).getText().equals("Permananet Address :Onesti");

    }

}