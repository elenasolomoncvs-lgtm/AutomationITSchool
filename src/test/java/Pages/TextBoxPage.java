package Pages;

import HelperMethods.ElementMetohods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage {
    WebDriver driver;
    ElementMetohods elementMethods;

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
        this.elementMethods =new ElementMetohods(driver);
        PageFactory.initElements(driver, this); //fara aceasta linie nu o sa gaseasca elementele
    }

    @FindBy(id = "userName")
    WebElement userNameField;

    @FindBy(id = "userEmail")
    WebElement userEmailField;

    @FindBy(id = "currentAddress")
    WebElement currentAddressField;

    @FindBy(id = "permanentAddress")
    WebElement permanentAddressField;

    @FindBy(id = "submit")
    WebElement submitButton;

    public void addNewEntry(String fullName, String userEmail, String currentAddress, String permanentAddress){
        enterFullName(fullName);
        enterUserEmail(userEmail);
        enterCurrentAddress(currentAddress);
        enterPermanentAddress(permanentAddress);
        clickOnSubmitButton();
    }

    public void enterFullName(String fullName){
        elementMethods.clickOnElement(userNameField);
        elementMethods.enterText(userNameField, fullName);
    }

    public void enterUserEmail(String userEmail){
        elementMethods.enterText(userEmailField, userEmail);
    }

    public void enterCurrentAddress(String currentAddress){
        elementMethods.enterText(currentAddressField, currentAddress);
    }

    public void enterPermanentAddress(String permanentAddress){
        elementMethods.enterText(permanentAddressField, permanentAddress);
    }

    public void clickOnSubmitButton() {
        elementMethods.clickOnElement(submitButton);
    }
}
