package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PracticeForumTest {

    @Test
    public void metodaTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 600);"); // 800 pixeli în jos

        Thread.sleep(2000);

        WebElement formsButton = driver.findElement(By.xpath("//h5[text()='Forms']"));
        formsButton.click();

        //js.executeScript("window.scrollBy(0, -800);");

        WebElement practiceFormButton = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        practiceFormButton.click();

        String gender = "Male";

        //(//*[@class='form-control'])[3]

        //*[@id='gender-radio-1']

        WebElement maleRadioFormButton = driver.findElement(By.xpath("//*[@id='gender-radio-1']"));
        //maleRadioFormButton.click();
        Thread.sleep(2000);

        WebElement femaleRadioFormButton = driver.findElement(By.xpath("//*[@id='gender-radio-2']"));
        //femaleRadioFormButton.click();

        Thread.sleep(2000);

        WebElement otherRadioFormButton = driver.findElement(By.xpath("//*[@id='gender-radio-3']"));
        otherRadioFormButton.click();

       /* if (gender.equals("Male")) {

            maleRadioFormButton.click();

        } else if (gender.equals("Female")) {
            femaleRadioFormButton.click();

        } else otherRadioFormButton.click();*/

       /* switch (gender) {

            case "Male":
                maleRadioFormButton.click();
                break;
            case "Female":
                femaleRadioFormButton.click();
                break;
            case "Other":
                otherRadioFormButton.click();
                break;
        }*/

    }

}
