package StepsDefinition;

import Pages.LoginPage;
import Pages.SearchPage;
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

public class SearchSteps {

    WebDriver driver = null;
    SearchPage searchPage;
    LoginPage loginPage ;


    @Given("user open browser and navigates to login page")
    public void UserNavigateToLoginPage() {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        searchPage = new SearchPage(driver);
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
    }

    @And("user should login successfully with valid email and password")
    public void LoginSuccessfully(){

        loginPage.loginSteps("kareem@outlook.com", "asdzxc");
        loginPage.loginBtn();
    }

    @When("user enters valid search query")
    public void EnterSearchQuery(){
        searchPage.searchTfElement.sendKeys("shoes");
        searchPage.searchTfElement.sendKeys(Keys.ENTER);
    }
    @When("user enter less than 3 character in search field")
    public void EnterInvalidSearchQuery(){
        searchPage.searchTfElement.sendKeys("s");
        searchPage.searchTfElement.sendKeys(Keys.ENTER);
    }
    @Then("user should see results in table of items")
    public void ShowQueryItems(){

        String expectedResult = "Search";
        String actualResult = searchPage.searchTitleElement.getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Then("error message should be displayed")
    public void ErrorMessageDisplayed(){

        String expectedResult = "Search term minimum length is 3 characters";
        String actualResult = searchPage.errorSerchMsg.getText();

        Assert.assertEquals(actualResult, expectedResult);
    }




}
