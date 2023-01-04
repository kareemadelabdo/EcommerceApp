package StepsDefinition;

import Pages.LoginPage;
import Pages.SelectCategoryPage;
import Pages.SwitchCurrenciesPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectCategorySteps {

    WebDriver driver = null;
    SelectCategoryPage selectCategoryPage;


    @Given("navigate to website for category")
    public void UserNavigateToLoginPage() {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        selectCategoryPage = new SelectCategoryPage(driver);

        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/");
    }
    @When("user select computers then desktop")
    public void UserSelectCategory() {
        selectCategoryPage.selectSubCategory();
    }
    @When("user select digital downloads")
    public void UserSelectOneCategory() {
        selectCategoryPage.selectCategory();
    }
    @Then("user should be directed to desktop page")
    public void CategoryPageDisplayed() {

        String expectedResult = "Desktops";
        String actualResult = selectCategoryPage.getResult().getText();
        Assert.assertEquals(expectedResult,actualResult);
    }

    @Then("user should be directed to digital downloads page")
    public void SubCategoryPageDisplayed() {

        String expectedResult = "Digital downloads";
        String actualResult = selectCategoryPage.getResult().getText();
        Assert.assertEquals(expectedResult,actualResult);
    }


}
