package StepsDefinition;

import Helper.BaseClass;
import Pages.AddToCompareListPage;
import Pages.AddToWishlistPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddProductToCompareListSteps {


    WebDriver driver = null;
    AddToCompareListPage addToCompareListPage;

    BaseClass base;

    public AddProductToCompareListSteps(BaseClass base) {
        this.base = base;
    }

    @Given("user choose apparel then shoes item")
    public void UserChooseItem() {
        base.getDriver().navigate().to("https://demo.nopcommerce.com/");
        addToCompareListPage = new AddToCompareListPage(base.getDriver());
        addToCompareListPage.selectSubCategory();
    }

    @When("user should choose color then add shoes to comparelist")
    public void AddToWishlist() throws InterruptedException {
        addToCompareListPage = new AddToCompareListPage(base.getDriver());
        addToCompareListPage.FirstAddToCart();
        Thread.sleep(2000);
        addToCompareListPage.ChooseColor();
        addToCompareListPage.ChooseSize();
        addToCompareListPage.AddToComparelistBtn();
    }

    @Then("comparelist success message should appear")
    public void WishListSuccessMessage() throws InterruptedException {

        addToCompareListPage = new AddToCompareListPage(base.getDriver());
        String expectedResult = "The product has been added to your ";
        String actualResult = addToCompareListPage.getSuccessMsg().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

}
