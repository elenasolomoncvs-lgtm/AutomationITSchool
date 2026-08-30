package Pages;

import HelperMethods.ElementMetohods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WebTablePage {

    WebDriver driver;
    ElementMetohods elementMethods;

    public WebTablePage(WebDriver driver) {
        this.driver = driver;
        this.elementMethods = new ElementMetohods(driver);
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
    WebElement  submitButton;

    @FindBy(xpath = "(//tr)[5]//td[1]")
    WebElement firstNameColumn;

    @FindBy(xpath = "(//tr)[5]//td[2]")
    WebElement lastNameColumn;

    @FindBy(xpath = "(//tr)[5]//td[3]")
    WebElement ageColumn;

    @FindBy(xpath = "(//tr)[5]//td[4]")
    WebElement emailColumn;

    @FindBy(xpath = "(//tr)[5]//td[5]")
    WebElement salaryColumn;

    @FindBy(xpath = "(//tr)[5]//td[6]")
    WebElement departmentColumn;


    public void addEntry(String firstName, String lastName, String userEmail, String age, String salary, String department){
        clickOnAddButton();
        enterFirstNameField(firstName);
        enterLastNameField(lastName);
        enterUserEmailField(userEmail);
        enterAgeField(age);
        enterSalaryField(salary);
        enterDepartmentField(department);
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

    public void enterUserEmailField(String email) {
        elementMethods.enterText(userEmailField,email);
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

    public void verifyEntry(String firstName, String lastName, String userEmail, String age, String salary, String department){

        Assert.assertTrue(firstNameColumn.getText().equals(firstName), "Prenumele nu a fost corect");
        Assert.assertTrue(lastNameColumn.getText().equals(lastName),"Numele nu a fost corect");
        Assert.assertTrue(ageColumn.getText().equals(age),"Varsta nu a fost corect");
        Assert.assertTrue(emailColumn.getText().equals(userEmail), "Email-ul nu a fost corect");
        Assert.assertEquals(salaryColumn.getText(),salary);
        Assert.assertTrue(departmentColumn.getText().equals(department),"Departamentul nu a fost corect");

    }




}
