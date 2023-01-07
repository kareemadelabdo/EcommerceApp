package StepsDefinition;

import Helper.BaseClass;
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

    WebDriver driver;
    SelectTagsPage selectTagsPage;
    SearchPage searchPage;

    BaseClass base;

    public SelectTagsSteps(BaseClass base) {
        this.base = base;
    }


    @Given("user choose specific tag")
    public void UserChooseTag() {

        base.getDriver().navigate().to("https://demo.nopcommerce.com/");
        searchPage = new SearchPage(base.getDriver());
        selectTagsPage = new SelectTagsPage(base.getDriver());
        searchPage.searchTfElement.sendKeys("shoes");
        searchPage.searchTfElement.sendKeys(Keys.ENTER);
        selectTagsPage.ClickOnTag();
    }

    @Then("items with this tag should be displayed")
    public void SuccessTagItemsDisplayed() {

        searchPage = new SearchPage(base.getDriver());
        selectTagsPage = new SelectTagsPage(base.getDriver());
        String expectedResult = "Products tagged with 'awesome'";
        String actualResult = selectTagsPage.getResult().getText();

        Assert.assertEquals(expectedResult, actualResult);
    }

}
