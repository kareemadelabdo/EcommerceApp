package StepsDefinition;

import Pages.LoginPage;
import Pages.SearchPage;
import Pages.SelectTagsPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectTagsSteps {

    WebDriver driver = null;
    SelectTagsPage selectTagsPage;
    SearchPage searchPage;

    @Given("user should navigate to home page and type validated word to search and then scroll down to choose tag")
    public void UserNavigateToLoginPage() {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        searchPage = new SearchPage(driver);
        selectTagsPage = new SelectTagsPage(driver);
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/");
        searchPage.searchTfElement.sendKeys("shoes");
        searchPage.searchTfElement.sendKeys(Keys.ENTER);
    }

    @When("user choose specific tag")
    public void UserChooseTag() {

        selectTagsPage.ClickOnTag();
    }

    @Then("items with this tag should be displayed")
    public void SuccessTagItemsDisplayed() {

        String expectedResult = "Products tagged with 'awesome'";
        String actualResult = selectTagsPage.getResult().getText();

        Assert.assertEquals(expectedResult,actualResult);
    }

}
