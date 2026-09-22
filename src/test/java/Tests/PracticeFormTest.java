package Tests;

import ObjectData.PracticeFormObject;
import ObjectData.WebTableObject;
import Pages.CommonPage;
import Pages.HomePage;
import Pages.PracticeFormPage;
import Shared_Data.Test_Base_Page;
import XmlReader.XmlDataLoader;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.util.Map;

public class PracticeFormTest extends Test_Base_Page {

    private Map<String, PracticeFormObject> PracticeFormObjectMap;

    @Test
    public void metodaTest() throws InterruptedException {

        PracticeFormObjectMap = XmlDataLoader.loadData("C:\\Users\\ASOC PROP Nr.13\\Desktop\\Proiect individual\\Automation_Sesiunea_1\\src\\test\\resources\\PracticeFormData.xml", PracticeFormObject.class);
        PracticeFormObject data = PracticeFormObjectMap.get("dataSet_1");

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0, 400);"); // 800 pixeli în jos

//        Thread.sleep(2000);

        HomePage homePage = new HomePage(getDriver());
        homePage.clickForms();

        js.executeScript("window.scrollBy(0, -400);");

        Thread.sleep(2000);

        CommonPage commonPage = new CommonPage(getDriver());
        commonPage.clickOnSubMenu("Practice Form");

        js.executeScript("window.scrollBy(0, 800);");

        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.completeFirstRegionField(data);
        practiceFormPage.completeGender(data);
        practiceFormPage.uploadPicture();
        practiceFormPage.completeStateAndCity(data);
        practiceFormPage.completeHobbies(data);
        practiceFormPage.completeCalendar(data);
        practiceFormPage.submit();

        //Assert trebuie adaugat sa fie complet testul
    }
}