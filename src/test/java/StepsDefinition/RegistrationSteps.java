package StepsDefinition;

import Pages.RegistrationPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationSteps {
    WebDriver driver = null;
    RegistrationPage registrationPage;

    @Given("user should open browser")
    public void OpenBrowser() {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);

        driver = new ChromeDriver();
        registrationPage = new RegistrationPage(driver);
        driver.manage().window().maximize();
    }

    @And("user should navigate to registration page")
    public void NavigateToWebsite() {
        driver.navigate().to("https://demo.nopcommerce.com/register?returnUrl=%2F");
    }

    @When("user enters valid data")
    public void UserEntersValidData() {
        registrationPage.RegistrationSteps("karkar", "adel", "abdo2@outlook.com", "companyX", "123456", "123456");
    }

    @And("user click on register button")
    public void Register() throws InterruptedException {
        Thread.sleep(4000);
        registrationPage.Register();
    }

    @Then("success message should be displayed")
    public void SuccessRegistration() {
        String actualResult = registrationPage.successMessage.getText();
        String expectedResult = "Your registration completed";

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Then("duplicate email message appears")
    public void DuplicateEmail() {
        String actualResult = registrationPage.errorDuplicateEmail.getText();
        String expectedResult = "The specified email already exists";

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Then("verify that firstname is required")
    public void RequiredFirstName() {
        String actualResult = registrationPage.firstNameError.getText();
        String expectedResult = "First name is required.";

        Assert.assertNotEquals(expectedResult, actualResult);
    }

    @Then("verify that lastname is required")
    public void RequiredLastName() {
        String actualResult = registrationPage.lastNameError.getText();
        String expectedResult = "Last name is required.";

        Assert.assertNotEquals(expectedResult, actualResult);
    }

    @Then("verify that email is required")
    public void RequiredEmail() {
        String actualResult = registrationPage.emailError.getText();
        String expectedResult = "Email is required.";

        Assert.assertNotEquals(expectedResult, actualResult);
    }

    @Then("verify that password is required")
    public void RequiredPassword() {
        String actualResult = registrationPage.passwordError.getText();
        String expectedResult = "Password is required.";

        Assert.assertNotEquals(expectedResult, actualResult);
    }

    @Then("verify that confirm password is required")
    public void RequiredConfirmPassword() {
        String actualResult = registrationPage.confirmPasswordError.getText();
        String expectedResult = "Password is required.";

        Assert.assertNotEquals(expectedResult, actualResult);
    }


}
