package Pages;

import HelperMethods.ElementMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;
    ElementMethods elementMethods;

    JavascriptExecutor js;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor)driver;
        this.elementMethods = new ElementMethods(driver);
        PageFactory.initElements(driver, this); //fara aceasta linie nu o sa gaseasca elementele
    }

    @FindBy(xpath = "//h5[text()='Elements']")
    WebElement elementsButton;

    @FindBy(xpath = "//h5[text()='Forms']")
    WebElement formsButton;

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    WebElement alertsButton;

    public void clickElements()
    {
        elementMethods.clickOnElement(elementsButton);
    }

    public void clickAlerts()
    {
        elementMethods.clickOnElement(alertsButton);

    }
    public void clickForms() {
        elementMethods.clickOnElement(formsButton);
    }

}
