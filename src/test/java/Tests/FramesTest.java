package Tests;

import Pages.CommonPage;
import Pages.FramesPage;
import Pages.HomePage;
import Shared_Data.Test_Base_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.List;

public class FramesTest extends Test_Base_Page {

    String text1 = "Textul din primul iframe este";
    String text2 = "Textul din al 2 - lea iframe este";

    @Test
    public void metodaTest(){

        ChromeOptions options = new ChromeOptions();

        options.addArguments(
                "--user-data-dir=C:\\SeleniumChromeProfile"
        );

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0, 800);"); // 800 pixeli în jos

        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlerts();

        CommonPage commonPage = new CommonPage(getDriver());
        commonPage.clickOnSubMenu("Frames");

        js.executeScript("window.scrollBy(0, -800);");

        FramesPage framesPage = new FramesPage(getDriver());
        framesPage.firstFrameElement();
        framesPage.firstFrameText();

        getDriver().switchTo().defaultContent();

        framesPage.secondFrameElement();
        framesPage.secondFrameText();

        getDriver().switchTo().defaultContent();

//        List<WebElement> cardList = getDriver().findElements(By.xpath("//*[@class='category-cards']//*[@data-discover='true']"));
//        cardList.get(2).click();
//
//        List<WebElement> elementsList = getDriver().findElements(By.xpath("//*[@class='element-list accordion-collapse collapse show']//*[@data-discover='true']"));
//        elementsList.get(2).click();
//
//        WebElement iframeElement = getDriver().findElement(By.id("frame1"));
//        getDriver().switchTo().frame(iframeElement);
//        WebElement iframeText = getDriver().findElement(By.id("sampleHeading"));
//        System.out.println(text1 + iframeText.getText());
//
//        getDriver().switchTo().defaultContent();
//
//        WebElement iframeElement2 = getDriver().findElement(By.id("frame2"));
//        getDriver().switchTo().frame(iframeElement2);
//        WebElement iframeText2 = getDriver().findElement(By.id("sampleHeading"));
//        System.out.println(text2 + iframeText2.getText());

//        getDriver().switchTo().defaultContent();


    }
}