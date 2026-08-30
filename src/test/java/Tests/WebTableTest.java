package Tests;

import Pages.CommonPage;
import Pages.HomePage;
import Pages.WebTablePage;
import Shared_Data.Test_Base_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class WebTableTest extends Test_Base_Page {

    @Test
    public void metodaTest() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--user-data-dir=C:\\SeleniumChromeProfile"
        );

//        WebDriver driver = new ChromeDriver(); // - primul pas deschide pagina Chrome
//        driver.manage().window().maximize(); // - maximizeaza ecranul  - full screen
//        driver.get("https://demoqa.com/"); // - deschide link-ul

        String firstName = "Elena";
        String lastName = "Solomon";
        String age = "25";
        String userEmail = "abc@ncid.net";
        String salary = "1000";
        String department = "IT test";


//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0, 800);"); // 800 pixeli în jos

        Thread.sleep(2000); // metoda Wait (pauza) daca codul ruleaza prea rapid - (2sec)

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0, 800);"); // 800 pixeli în jos

//        WebElement elementsButton = driver.findElement(By.xpath("//h5[text()='Elements']"));
//        elementsButton.click();

        HomePage homePage = new HomePage(getDriver());
        homePage.clickElements();

        js.executeScript("window.scrollBy(0, -800);");

//        WebElement webTableButton = driver.findElement(By.xpath("//span[text()='Web Tables']"));
//        webTableButton.click();

        Thread.sleep(2000);

//        WebElement webElementButton = driver.findElement(By.xpath("//span[text()='Web Tables']"));
//        webElementButton.click();

        CommonPage commonPage = new CommonPage(getDriver());
        commonPage.clickOnSubMenu("Web Tables");


        Thread.sleep(2000);

//        WebElement addButton = driver.findElement(By.id("addNewRecordButton"));
//        addButton.click();
//        Thread.sleep(2000);
//
//        WebElement firstNameField = driver.findElement(By.id("firstName"));
//        firstNameField.sendKeys(firstName);
//
//        WebElement lastNameField = driver.findElement(By.id("lastName"));
//        lastNameField.sendKeys(lastName);
//
//        WebElement userEmailField = driver.findElement(By.id("userEmail"));
//        userEmailField.sendKeys(userEmail);
//
//        WebElement ageField = driver.findElement(By.id("age"));
//        ageField.sendKeys(age);
//
//        WebElement salaryField = driver.findElement(By.id("salary"));
//        salaryField.sendKeys(salary);
//
//        WebElement departmentField = driver.findElement(By.id("department"));
//        departmentField.sendKeys(department);
//
//        WebElement submitButton = driver.findElement(By.id("submit"));
//        submitButton.click();
//
//        WebElement rowAdded = driver.findElement(By.xpath("(//tr)[5]"));
//        String rowAddedText = rowAdded.getText();
//        System.out.println(rowAddedText);


//        *[text()='Web Tables']
//        (//li[@id='item-3'])[1]
//        [@class='element-list accordion-collapse collapse show']//li[@id='item-3']       -> //cea mai buna varianta
//        [@class='element-list accordion-collapse collapse show']//[@class='menu-list']//li[@id='item-3']
//        [@class='element-list accordion-collapse collapse show']//[@class='menu-list']//*[@class='btn btn-light ' and contains(@id, 'item-3')]
//
//        h5[text()='Elements'] - xpath relativ (ceam mai buna metoda)
//        html/body/div[1]/div/div/div[2]/div/a[1]/div/div/div[3]/h5 - xpath absolut
//        *[@id="root"]/div/div/div[2]/div/a[1]/div/div/div[3]/h5 - xpath absolut

        WebTablePage webTablePage = new WebTablePage(getDriver());
//        webTablePage.clickOnAddButton();
//        webTablePage.enterFirstNameField(firstName);
//        webTablePage.enterLastNameField(lastName);
//        webTablePage.enterAgeField(age);
//        webTablePage.enterUserEmailField(userEmail);
//        webTablePage.enterSalaryField(salary);
//        webTablePage.enterDepartmentField(department);
//        webTablePage.clickOnSubmitButton();

        webTablePage.addEntry(firstName, lastName, userEmail, age, salary, department);
        webTablePage.addEntry("John", "Doe", "abc@gmail.com", "45", "15000", "IT");



        WebElement rowAdded = getDriver().findElement(By.xpath("(//tr)[5]"));
        String rowAddedText = rowAdded.getText();
        System.out.println(rowAddedText);

        js.executeScript("window.scrollBy(0, -800);");


//        Assert.assertTrue(rowAddedText.contains("Elena"));
//        Assert.assertTrue(rowAddedText.contains("Solomon"));
//        Assert.assertTrue(rowAddedText.contains("25"));
//        Assert.assertTrue(rowAddedText.contains("abc@ncid.net"));
//        Assert.assertTrue(rowAddedText.contains("1000"));
//        Assert.assertTrue(rowAddedText.contains("IT test"));

//        WebElement firstNameColumn = driver.findElement(By.xpath("(//tr)[5]//td[1]"));
//        WebElement lastNameColumn = driver.findElement(By.xpath("(//tr)[5]//td[2]"));
//        WebElement ageColumn = driver.findElement(By.xpath("(//tr)[5]//td[3]"));
//        WebElement emailColumn = driver.findElement(By.xpath("(//tr)[5]//td[4]"));
//        WebElement salaryColumn = driver.findElement(By.xpath("(//tr)[5]//td[5]"));
//        WebElement departmentColumn = driver.findElement(By.xpath("(//tr)[5]//td[6]"));
//
//        String firstNameColumnText = firstNameColumn.getText();
//        String lastNameColumnText = lastNameColumn.getText();
//        String ageColumnText = ageColumn.getText();
//        String emailColumnText = emailColumn.getText();
//        String salaryColumnText = salaryColumn.getText();
//        String departmentColumnText = departmentColumn.getText();
//
//        Assert.assertTrue(firstNameColumnText.equals("Elena"));
//        Assert.assertTrue(lastNameColumnText.equals("Solomon"));
//        Assert.assertTrue(ageColumnText.equals("25"));
//        Assert.assertTrue(emailColumnText.equals("abc@ncid.net"), "Email-ul nu a fost corect");
//        Assert.assertEquals(salaryColumnText,"1000");
//        Assert.assertTrue(departmentColumnText.equals("IT test"));
//        Assert.assertEquals(departmentColumn.getText(),"IT test");

        webTablePage.verifyEntry(firstName,lastName,userEmail,age, salary, department);


        // (//*["class='rt-tr-group'[4])


    }
}
