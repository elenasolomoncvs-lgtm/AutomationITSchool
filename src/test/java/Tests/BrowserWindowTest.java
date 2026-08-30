package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowTest {

    String text1 = "Textul din tabul 2 este";
    String text2 = "Textul din tabul al 2- lea este";

    @Test
    public void metodaTest(){


        ChromeOptions options = new ChromeOptions();

        options.addArguments(
                "--user-data-dir=C:\\SeleniumChromeProfile"
        );

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");

        List<WebElement> cardList = driver.findElements(By.xpath("//*[@class='category-cards']//*[@data-discover='true']"));
        cardList.get(2).click();

        List<WebElement> elementsList = driver.findElements(By.xpath("//*[@class='element-list accordion-collapse collapse show']//*[@data-discover='true']"));
        elementsList.get(0).click();

        WebElement tabButton = driver.findElement(By.id("tabButton"));
        tabButton.click();

        List<String> tabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(1));

        WebElement newTabText = driver.findElement(By.id("sampleHeading"));
        System.out.println(text1 + newTabText.getText());


        driver.close();
        driver.switchTo().window(tabList.getFirst());

        WebElement windowButton = driver.findElement(By.id("windowButton"));
        windowButton.click();

        List<String> newWindowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newWindowList.get(1));

        WebElement newWindowText = driver.findElement(By.id("sampleHeading"));
        System.out.println(text2 + newWindowText.getText());

        driver.manage().window().maximize();

        driver.close();

    }
}
