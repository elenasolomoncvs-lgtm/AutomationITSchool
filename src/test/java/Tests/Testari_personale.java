package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

    public class Testari_personale {

    @Test
    public void metodaTest() throws InterruptedException {
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://demoqa.com/");     //h5[text()='Elements'] - xpath

        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0, 800);");    //800 pixeli in jos

        Thread.sleep(2000);

        WebElement elementsButton = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsButton.click();

        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 800);");    //800 pixeli in jos

        WebElement webTableButton = driver.findElement(By.xpath("//*[@class='element-list accordion-collapse collapse show'] //*[@class='btn btn-light ' and contains(@id, 'item-3')]"));
        elementsButton.click();






        // first session of automation testing



    }
}
