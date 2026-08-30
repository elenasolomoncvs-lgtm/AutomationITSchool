package Pages;

import HelperMethods.ElementMetohods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CommonPage {

    WebDriver driver;
    ElementMetohods elementMethods;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        this.elementMethods = new ElementMetohods(driver);
        PageFactory.initElements(driver, this); //fara aceasta linie nu o sa gaseasca elementele

    }
    @FindBy(xpath = "//span[@class='text']")
    List<WebElement> elements;

    public void clickOnSubMenu(String text)
    {
        elementMethods.selectElementFromListByText(elements,text);
    }


}
