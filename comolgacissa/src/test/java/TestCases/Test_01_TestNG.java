package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.KatalonFormPage;

public class Test_01_TestNG {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/users/olgacissa/downloads/chromedriver 2");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String baseUrl = "http://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html";
        driver.get(baseUrl);


    }

    @Test(dataProvider = "usernameFirstLastNamesAndDOB")
    public void testFormCanBeSubmitted(String firstName, String lastName, String dob) throws InterruptedException {
        Thread.sleep(3000);

        KatalonFormPage katalonFormPage = new KatalonFormPage(driver);
        katalonFormPage.setFirstNameInput(firstName);
        katalonFormPage.setLastNameInput(lastName);
        katalonFormPage.setGenderInput();
        katalonFormPage.setDobInput(dob);
        katalonFormPage.setAddressInput("222 n riverside plaza, Chicago, IL 60602");
        katalonFormPage.setEmailInput("test@test.com");
        katalonFormPage.setPasswordInput("test");
        katalonFormPage.setCompanyNameInput("ForteKnowledge");
        katalonFormPage.selectRole("QA");
        katalonFormPage.setJobExpectation("High salary", "Challenging", "Good teamwork");
        katalonFormPage.setWaysOfDevelopment();
        katalonFormPage.setCommentInput("This is my comment");
        katalonFormPage.submitForm();
    }

    @Test(priority = 1)
    public void testSuccessMessageIsDisplayed() {
        KatalonFormPage katalonFormPage = new KatalonFormPage(driver);
        katalonFormPage.checkMessageIsDisplayed();


    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "usernameFirstLastNamesAndDOB")
    public Object[][] dataGenerator() {
        Object[][] testData = new Object[3][3];
        testData[0][0] = ("Olga");
        testData[0][1] = ("Cissa");
        testData[0][2] = ("04/04/1990");
        testData[1][0] = ("Slava");
        testData[1][1] = ("Cissa");
        testData[1][2] = ("04/04/1987");
        testData[2][0] = ("Aditi");
        testData[2][1] = ("Test");
        testData[2][2] = ("04/04/1988");
        return testData;
    }


}
