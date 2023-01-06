package StepsDefinition;

import Pages.LoginPage;
import Pages.RegistrationPage;
import Pages.ResetPasswordPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;

public class ResetPasswordSteps {
    WebDriver driver = null;
    ResetPasswordPage resetPasswordPage;

    @Given("user should open browser and navigate to reset password page")
    public void NavigateToResetPasswordPage() {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);

        driver = new ChromeDriver();
        resetPasswordPage = new ResetPasswordPage(driver);
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/passwordrecovery");
    }

    @When("user enter valid email and click on recover")
    public void ValidEmail() {

        resetPasswordPage.emailElement.sendKeys("kareem@outlook.com");
        resetPasswordPage.emailElement.sendKeys(Keys.ENTER);
    }
    @When("user enter empty email")
    public void EmptyEmail() {

        resetPasswordPage.emailElement.sendKeys("");
        resetPasswordPage.emailElement.sendKeys(Keys.ENTER);
    }
    @When("user enter wrong email not saved in system database")
    public void WrongEmail() {

        resetPasswordPage.emailElement.sendKeys("kareem@outlook.com");
        resetPasswordPage.emailElement.sendKeys(Keys.ENTER);
    }
    @When("user enter email with wrong format")
    public void WrongEmailFormat() {

        resetPasswordPage.emailElement.sendKeys("kareem");
        resetPasswordPage.emailElement.sendKeys(Keys.ENTER);
    }

    @Then("success message should appear to user")
    public void Success() {

        String actualResult = "Email with instructions has been sent to you.";
        String expectedResult = resetPasswordPage.successMessage.getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Then("message displayed stating that email is empty")
    public void EmptyEmailError() {

        String actualResult = "Enter your email";
        String expectedResult = resetPasswordPage.emptyEmailError.getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Then("message should be displayed stating that email not found")
    public void WrongEmailError() {

        String actualResult = "Email not found.";
        String expectedResult = resetPasswordPage.wrongEmailError.getText();
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Then("message displayed stating that email is in wrong format")
    public void WrongEmailFormatError() {

        String actualResult = "Wrong email";
        String expectedResult = resetPasswordPage.emailFormatError.getText();
        Assert.assertEquals(actualResult, expectedResult);
    }



}
