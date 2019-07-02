package stepdefinitions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.KatalonFormPage;

public class FormAutomationStepdefs {
    WebDriver driver;
    KatalonFormPage katalon;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/users/olgacissa/downloads/chromedriver 2");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        katalon = new KatalonFormPage(driver);
    }

    @Given("^Form is opened$")
    public void formIsOpened() {

        System.out.println("this is background");
    }

    @Given("^user navigates to the form$")
    public void userNavigatesToTheForm() {
        String baseUrl = "http://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html";
        driver.get(baseUrl);

    }

    @When("^enters first name \"([^\"]*)\"$")
    public void entersFirstName(String firstName) {

        katalon.setFirstNameInput(firstName);

    }


    @And("^enters last name \"([^\"]*)\"$")
    public void entersLastName(String lastName)  {
        katalon.setLastNameInput(lastName);
    }

    @And("^enters gender$")
    public void entersGender() {
        katalon.setGenderInput();

    }

    @And("^enters date of birth \"([^\"]*)\"$")
    public void entersDateOfBirth(String dateOfBirth)  {
        katalon.setDobInput(dateOfBirth);

    }

    @And("^enters address$")
    public void entersAddress() {
        katalon.setAddressInput("222 n riverside plaza, Chicago, IL 60602");


    }

    @And("^enters email$")
    public void entersEmail() {
        katalon.setEmailInput("test@test.com");

    }

    @And("^enters password$")
    public void entersPassword() {
        katalon.setPasswordInput("test");

    }

    @And("^enters company name$")
    public void entersCompanyName() {
        katalon.setCompanyNameInput("ForteKnowledge");

    }

    @And("^selects a role$")
    public void selectsARole() {
        katalon.selectRole("QA");

    }

    @And("^selects job's expectation$")
    public void selectsJobSExpectation() {
        katalon.setJobExpectation("High salary", "Challenging", "Good teamwork");

    }

    @And("^selects ways of development$")
    public void selectsWaysOfDevelopment() {
        katalon.setWaysOfDevelopment();

    }

    @And("^enters a comment$")
    public void entersAComment() {
        katalon.setCommentInput("This is my comment");
    }

    @And("^clicks submit button$")
    public void clicksSubmitButton() {
        katalon.submitForm();

    }

    @Then("^form is submitted$")
    public void formIsSubmitted() {
        katalon.checkMessageIsDisplayed();

    }
    @After
    public void clear(){
        driver.quit();
    }

}
