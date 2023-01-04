package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "FirstName")
    WebElement firstNameElement;
    @FindBy(id = "LastName")
    WebElement lastNameElement;
    @FindBy(id = "Email")
    WebElement emailElement;
    @FindBy(id = "Company")
    WebElement companyElement;
    @FindBy(id = "Password")
    WebElement passwordElement;
    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordElement;
    @FindBy(id = "register-button")
    WebElement registerBtnElement;
    @FindBy(className = "result")
    public WebElement successMessage;
    @FindBy(className = "message-error")
    public WebElement errorDuplicateEmail;
    @FindBy(id = "FirstName-error")
    public WebElement firstNameError;
    @FindBy(id = "LastName-error")
    public WebElement lastNameError;
    @FindBy(id = "Email-error")
    public WebElement emailError;
    @FindBy(id = "Password-error")
    public WebElement passwordError;
    @FindBy(id = "ConfirmPassword-error")
    public WebElement confirmPasswordError;

    public void RegistrationSteps(String firstName, String lastName, String email, String company, String password, String confirmPassword) {
        firstNameElement.sendKeys(firstName);
        lastNameElement.sendKeys(lastName);
        emailElement.sendKeys(email);
        companyElement.sendKeys(company);
        passwordElement.sendKeys(password);
        confirmPasswordElement.sendKeys(confirmPassword);
    }

    public void Register() {
        registerBtnElement.click();
    }


}
