package StepsDefinition;

import Pages.LoginPage;
import Pages.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {

    WebDriver driver = null;
    LoginPage loginPage;


    @Given("user should open browser and navigates to login page")
    public void NavigateToLoginPage() {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);

        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
    }

    @And("user enters credentials")
    public void LoginCredentials() {
        loginPage.loginSteps("kareem@outlook.com", "asdzxc");
        loginPage.loginBtn();
    }
    @And("user enters invalid credentials")
    public void invalidLoginCredentials() {
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

        String actualResult = driver.getCurrentUrl();
        String expectedResult = "https://demo.nopcommerce.com/";

        Assert.assertEquals(actualResult, expectedResult);
    }
}
