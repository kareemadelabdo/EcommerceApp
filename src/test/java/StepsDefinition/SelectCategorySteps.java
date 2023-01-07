package StepsDefinition;

import Helper.BaseClass;
import Pages.LoginPage;
import Pages.SelectCategoryPage;
import Pages.SwitchCurrenciesPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectCategorySteps {

    WebDriver driver;
    SelectCategoryPage selectCategoryPage;

    BaseClass base;

    public SelectCategorySteps(BaseClass base) {
        this.base = base;
    }

    @Given("user select computers then desktop")
    public void UserSelectCategory() {
        base.getDriver().navigate().to("https://demo.nopcommerce.com/");
        selectCategoryPage = new SelectCategoryPage(base.getDriver());
        selectCategoryPage.selectSubCategory();
    }

    @Given("user select digital downloads")
    public void UserSelectOneCategory() {
        base.getDriver().navigate().to("https://demo.nopcommerce.com/");
        selectCategoryPage = new SelectCategoryPage(base.getDriver());
        selectCategoryPage.selectCategory();
    }

    @Then("user should be directed to desktop page")
    public void CategoryPageDisplayed() {
        selectCategoryPage = new SelectCategoryPage(base.getDriver());
        String expectedResult = "Desktops";
        String actualResult = selectCategoryPage.getResult().getText();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Then("user should be directed to digital downloads page")
    public void SubCategoryPageDisplayed() {
        selectCategoryPage = new SelectCategoryPage(base.getDriver());
        String expectedResult = "Digital downloads";
        String actualResult = selectCategoryPage.getResult().getText();
        Assert.assertEquals(expectedResult, actualResult);
    }


}
