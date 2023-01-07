package StepsDefinition;

import Helper.BaseClass;
import Pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;
    BaseClass base;

    public LoginSteps(BaseClass base) {
        this.base = base;
    }

    @When("user enters credentials")
    public void LoginCredentials() {
        loginPage = new LoginPage(base.getDriver());
        base.getDriver().navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
        loginPage.loginSteps("kareem@outlook.com", "asdzxc");
        loginPage.loginBtn();
    }

    @When("user enters invalid credentials")
    public void invalidLoginCredentials() {
        loginPage = new LoginPage(base.getDriver());
        base.getDriver().navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
        loginPage.loginSteps("kareemqd@outlook.com", "123456");
        loginPage.loginBtn();
    }

    @Then("login unsuccessful with invalid data")
    public void LoginNotSuccessful() {

        String actualResult = loginPage.errorLoginMsg.getText();
        String expectedResult = "Login was unsuccessful. Please correct the errors and try again.";

        Assert.assertTrue(actualResult.contains(expectedResult));
    }


    @Then("login successfully with valid data")
    public void LoginSuccessful() {

        String actualResult = base.getDriver().getCurrentUrl();
        String expectedResult = "https://demo.nopcommerce.com/";

        Assert.assertEquals(actualResult, expectedResult);
    }

}
