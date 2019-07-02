package stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.KatalonFormPage;

public class Hooks {
WebDriver driver;
KatalonFormPage katalon;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/users/olgacissa/downloads/chromedriver 2");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        katalon = new KatalonFormPage(driver);
//        String baseUrl = "http://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html";
//        driver.get(baseUrl);

    }
    @After
    public void clear(){
        driver.quit();
    }
}
