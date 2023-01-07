package StepsDefinition;

import Helper.BaseClass;
import Pages.FilterWithColorPage;
import Pages.SelectCategoryPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FilterWithColorSteps {

    WebDriver driver;
    FilterWithColorPage filterWithColorPage;

    BaseClass base;

    public FilterWithColorSteps(BaseClass base) {
        this.base = base;
    }
    
    @Given("user should hover on apparel then click on choose")
    public void UserChooseItem() {

        base.getDriver().navigate().to("https://demo.nopcommerce.com/");
        filterWithColorPage = new FilterWithColorPage(base.getDriver());
        filterWithColorPage.selectItem();
    }

    @Then("user should be able to choose color")
    public void UserChooseColor() {
        filterWithColorPage = new FilterWithColorPage(base.getDriver());
        filterWithColorPage.ChooseColor();
    }

}
