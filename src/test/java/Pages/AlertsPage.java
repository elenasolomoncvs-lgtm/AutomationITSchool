package Pages;

import HelperMethods.AlertMethods;
import HelperMethods.ElementMetohods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage {

    WebDriver driver;
    ElementMetohods elementMethods;
    AlertMethods alertMethods;

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
        this.elementMethods = new ElementMetohods(driver);
        this.alertMethods = new AlertMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//*[@id='alertButton']")
    WebElement alertButton;

    @FindBy(xpath = "//*[@id ='timerAlertButton']")
    WebElement timerAlertButton;

    @FindBy(xpath = "//*[@id ='confirmButton']")
    WebElement confirmButton;

    @FindBy(xpath = "//*[@id ='promtButton']")
    WebElement promtButton;

    public void  dealWithAlertOk(){
        elementMethods.clickOnElement(alertButton);
        alertMethods.alertOk();
    }

    public void dealWithAlertDelay(int seconds){
        elementMethods.clickOnElement(timerAlertButton);
        alertMethods.alertWithDelay(seconds);
    }

    public void alertConfirm(){
        elementMethods.clickOnElement(confirmButton);
        alertMethods.alertConfirm();
    }
    public void alertCancel(){
        elementMethods.clickOnElement(confirmButton);
        alertMethods.alertCancel();
    }

    public void alertPrompt(String value){
        elementMethods.clickOnElement(promtButton);
        alertMethods.alertText(value);
    }

}
