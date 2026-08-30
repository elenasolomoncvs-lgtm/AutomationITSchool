package Pages;

import HelperMethods.ElementMetohods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FramesPage  {

    WebDriver driver;
    ElementMetohods elementMethods;

    public FramesPage(WebDriver driver) {
        this.driver = driver;
        this.elementMethods = new ElementMetohods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "frame1")
    WebElement ifFrameElement;

    @FindBy(id = "sampleHeading")
    WebElement ifFrameText;

    @FindBy(id = "frame2")
    WebElement ifFrameElement2;

    public void firstFrameElement(){
        driver.switchTo().frame(ifFrameElement);
    }

    public void firstFrameText(){
        Assert.assertEquals(ifFrameText.getText(), "This is a sample page");
    }

    public void secondFrameElement(){
        driver.switchTo().frame(ifFrameElement2);
    }

    public void secondFrameText(){
        Assert.assertEquals(ifFrameText.getText(), "This is a sample page");
    }
}

