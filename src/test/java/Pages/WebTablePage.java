package Pages;

import HelperMethods.ElementMethods;
import Logger.LoggerUtility;
import ObjectData.WebTableObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WebTablePage {

    WebDriver driver;
    ElementMethods elementMethods;

    public WebTablePage(WebDriver driver) {
        this.driver = driver;
        this.elementMethods = new ElementMethods(driver);
        PageFactory.initElements(driver, this); //fara aceasta linie nu o sa gaseasca elementele
    }

    @FindBy(id = "addNewRecordButton")
    WebElement addButton;

    @FindBy(id = "firstName")
    WebElement firstNameField;

    @FindBy(id = "lastName")
    WebElement lastNameField;

    @FindBy(id = "userEmail")
    WebElement userEmailField;

    @FindBy(id = "age")
    WebElement ageField;

    @FindBy(id = "salary")
    WebElement salaryField;

    @FindBy(id = "department")
    WebElement departmentField;

    @FindBy(id = "submit")
    WebElement submitButton;

    @FindBy(xpath = "(//tr)[5]//td[1]")
    WebElement firstNameColumn;

    @FindBy(xpath = "(//tr)[5]//td[2]")
    WebElement lastNameColumn;

    @FindBy(xpath = "(//tr)[5]//td[3]")
    WebElement ageColumn;

    @FindBy(xpath = "(//tr)[5]//td[4]")
    WebElement userEmailColumn;

    @FindBy(xpath = "(//tr)[5]//td[5]")
    WebElement salaryColumn;

    @FindBy(xpath = "(//tr)[5]//td[6]")
    WebElement departmentColumn;


    public void addEntry(WebTableObject data){
        clickOnAddButton();
        LoggerUtility.infoTestCase("User clicked on add Button");
        enterFirstNameField(data.getFirstName());
        LoggerUtility.infoTestCase("User entered First Name");
        enterLastNameField(data.getLastName());
        LoggerUtility.infoTestCase("User entered Last Name");
        enterUserEmailField(data.getEmail());
        LoggerUtility.infoTestCase("User entered the Email");
        enterAgeField(data.getAge());
        LoggerUtility.infoTestCase("User entered the Age");
        enterSalaryField(data.getSalary());
        LoggerUtility.infoTestCase("User entered the Salary");
        enterDepartmentField(data.getDepartment());
        LoggerUtility.infoTestCase("User entered the Department");
        clickOnSubmitButton();
    }


    public void clickOnAddButton() {
        elementMethods.clickOnElement(addButton);
    }

    public void enterFirstNameField(String firstName) {
        elementMethods.enterText(firstNameField,firstName);
    }

    public void enterLastNameField(String lastName) {
        elementMethods.enterText(lastNameField,lastName);
    }

    public void enterUserEmailField(String userEmail) {
        elementMethods.enterText(userEmailField,userEmail);
    }

    public void enterAgeField(String age) {
        elementMethods.enterText(ageField,age);
    }

    public void enterSalaryField(String salary) {
        elementMethods.enterText(salaryField,salary);
    }

    public void enterDepartmentField(String departmentText) {
        elementMethods.enterText(departmentField,departmentText);
    }

    public void clickOnSubmitButton() {
        elementMethods.clickOnElement(submitButton);
    }

    public void verifyEntry(WebTableObject data ){

        Assert.assertTrue(firstNameColumn.getText().equals(data.getFirstName()), "Prenumele nu a fost corect");
        LoggerUtility.infoTestCase("User verified First Name");
        Assert.assertTrue(lastNameColumn.getText().equals(data.getFirstName()),"Numele nu a fost corect");
        LoggerUtility.infoTestCase("User verified Last Name");
        Assert.assertTrue(ageColumn.getText().equals(data.getAge()),"Varsta nu a fost corect");
        LoggerUtility.infoTestCase("User verified the Age");
        Assert.assertTrue(userEmailColumn.getText().equals(data.getEmail()), "Email-ul nu a fost corect");
        LoggerUtility.infoTestCase("User verified the Email");
        Assert.assertEquals(salaryColumn.getText(),data.getSalary());
        LoggerUtility.infoTestCase("User verified the Salary");
        Assert.assertTrue(departmentColumn.getText().equals(data.getDepartment()),"Departamentul nu a fost corect");
        LoggerUtility.infoTestCase("User verified the Department");
    }
}
