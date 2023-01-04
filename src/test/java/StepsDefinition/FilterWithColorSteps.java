package StepsDefinition;

import Pages.FilterWithColorPage;
import Pages.SelectCategoryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FilterWithColorSteps {

    WebDriver driver = null;
    FilterWithColorPage filterWithColorPage;


    @Given("user should navigate to website")
    public void UserNavigateToLoginPage() {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        filterWithColorPage = new FilterWithColorPage(driver);

        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @When("user should hover on apparel then click on choose")
    public void UserChooseItem() {

        filterWithColorPage.selectItem();
    }

    @Then("user should be able to choose color")
    public void UserChooseColor() {

        filterWithColorPage.ChooseColor();
    }
}
