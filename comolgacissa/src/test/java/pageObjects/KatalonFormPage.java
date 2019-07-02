package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
public class KatalonFormPage {

    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "submit")
    private WebElement submit_Formbutton;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "role")
    private WebElement roleDropdown;

    @FindBys(@FindBy(name = "gender"))
    private List<WebElement> genderInput;

    @FindBy(id = "dob")
    private WebElement dobInput;

    @FindBy(id = "address")
    private WebElement addressInput;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "company")
    private WebElement companyNameInput;

    @FindBy(id = "expectation")
    private WebElement jobExpectation;

    @FindBy(css = ".development-ways input[type=checkbox]")
    private List<WebElement> waysOfDevelopment;

    @FindBy(id = "comment")
    private WebElement commentInput;

    @FindBy(id = "submit-msg")
    WebElement checkMessage;


    public KatalonFormPage(WebDriver driver) {  //this is constructor

        PageFactory.initElements(driver, this);
    }


    public void setFirstNameInput(String firstName) {
        firstNameInput.clear();
        this.firstNameInput.sendKeys(firstName);
    }

    public void setLastNameInput(String lastName) {
        this.lastNameInput.clear();
        this.lastNameInput.sendKeys(lastName);
    }

    public void setGenderInput() {

        genderInput.get(1).click();
    }

    public void setDobInput(String dob) {

        dobInput.sendKeys(dob);
    }

    public void setAddressInput(String address) {
        addressInput.click();
        addressInput.sendKeys(address);
    }

    public void setEmailInput(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void setPasswordInput(String password) {
        passwordInput.sendKeys(password);
    }

    public void setCompanyNameInput(String company) {
        companyNameInput.sendKeys(company);

    }

    public void selectRole(String role) {
        Select dropdown = new Select(roleDropdown);

        dropdown.selectByVisibleText(role);
    }

    public void setJobExpectation(String text1, String text2, String text3) {
        Select select = new Select(jobExpectation);
        select.selectByVisibleText(text1);
        select.selectByVisibleText(text2);
        select.selectByVisibleText(text3);
    }

    public void setWaysOfDevelopment() {
        Random random = new Random();
        HashSet<Integer> set = new HashSet<Integer>(3);
        while (set.size() < 3) {
            set.add(random.nextInt(waysOfDevelopment.size()));
        }
        System.out.println(set);
        for (int i : set) {
            waysOfDevelopment.get(i).click();
        }

    }

    public void setCommentInput(String text) {
        commentInput.sendKeys(text);

    }

    public void submitForm() {

        submit_Formbutton.click();

    }

    public void checkMessageIsDisplayed() {

        Assert.assertTrue(checkMessage.isDisplayed());
         System.out.println("Test Passed, Text “Successfully submitted!” is presented");

    }


}
