package Pages;

import HelperMethods.ElementMethods;
import ObjectData.PracticeFormObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormPage {
    WebDriver driver;
    ElementMethods elementsMethods;

    public PracticeFormPage(WebDriver driver){
        this.driver = driver;
        this.elementsMethods = new ElementMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstName")
    WebElement firstNameField;

    @FindBy(id = "lastName")
    WebElement lastNameField;

    @FindBy(id = "userEmail")
    WebElement userEmailField;

    @FindBy(id = "gender-radio-1")
    WebElement genderRatioMale;

    @FindBy(id = "gender-radio-2")
    WebElement genderRatioFemale;

    @FindBy(id = "gender-radio-3")
    WebElement genderRatioOther;

    @FindBy(id = "userNumber")
    WebElement userNumber;

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput;

    @FindBy(id ="subjectsInput")
    WebElement subjectField;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    WebElement sportsBox;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    WebElement readingBox;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    WebElement musicBox;

    @FindBy(id = "currentAddress")
    WebElement currentAddressField;

    @FindBy(id = "state")
    WebElement stateField;

    @FindBy(id = "city")
    WebElement cityField;

    @FindBy(id = "submit")
    WebElement  submitButton;

    @FindBy(id = "uploadPicture")
    WebElement pictureElement;

    @FindBy(id = "dateOfBirthInput")
    WebElement calendarInput;

    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
    WebElement monthSelect;

    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    WebElement yearSelect;

    public void completeFirstRegionField(PracticeFormObject data){
        elementsMethods.enterText(firstNameField, data.getFirstName());
        elementsMethods.enterText(lastNameField, data.getLastName());
        elementsMethods.enterText(userEmailField, data.getEmailAddress());
        elementsMethods.enterText(currentAddressField, data.getCurrent());
        elementsMethods.enterText(userNumber, data.getPhoneNumber());
        elementsMethods.enterTextWithEnter(subjectField, data.getSubjects());
    }

    public void completeGender(PracticeFormObject data) {
        switch (data.getGender()) {
            case "Male":
                genderRatioMale.click();
                break;
            case "Female":
                genderRatioFemale.click();
                break;
            case "Other":
                genderRatioOther.click();
                break;
        }
    }
    public void uploadPicture(){
        elementsMethods.uploadPicture(pictureElement);
    }

    public void completeStateAndCity(PracticeFormObject data){
        elementsMethods.clickOnElement(stateField);
        elementsMethods.enterTextUsingActions(stateField, data.getState());
        elementsMethods.clickOnElement(cityField);
        elementsMethods.enterTextUsingActions(cityField, data.getCity());
    }

    public void completeHobbies(PracticeFormObject data){
        List<WebElement> hobbiesElements = new ArrayList<>();
        hobbiesElements.add(sportsBox);
        hobbiesElements.add(readingBox);
        hobbiesElements.add(musicBox);
        elementsMethods.clickMultipleValues(hobbiesElements,data.getHobbies());

    }

    public void completeCalendar(PracticeFormObject data) {
        elementsMethods.clickOnElement(calendarInput);
        elementsMethods.selectByText(monthSelect, data.getMonth());
        elementsMethods.selectByValue(yearSelect, data.getYear());

        WebElement day = driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--0" + data.getDay() + "' and not(contains(@class, 'react-datepicker__day--outside-month'))]"));
        elementsMethods.clickOnElement(day);
    }

    public void submit(){
        submitButton.submit();
    }
}
