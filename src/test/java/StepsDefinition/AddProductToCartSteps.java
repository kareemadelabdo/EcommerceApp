package StepsDefinition;

import Helper.BaseClass;
import Pages.AddToCartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class AddProductToCartSteps {
    WebDriver driver;
    AddToCartPage addToCartPage;
    BaseClass base;

    public AddProductToCartSteps(BaseClass base) {
        this.base = base;
    }

    @Given("user should choose apparel then shoes")
    public void UserChooseItem() {
        base.getDriver().navigate().to("https://demo.nopcommerce.com/");
        addToCartPage = new AddToCartPage(base.getDriver());
        addToCartPage.selectSubCategory();
    }

    @When("user should choose color and add shoes to cart and go to cart page to view it")
    public void AddToCart() throws InterruptedException {
        addToCartPage = new AddToCartPage(base.getDriver());
        addToCartPage.FirstAddToCart();
        Thread.sleep(2000);
        addToCartPage.ChooseColor();
        addToCartPage.ChooseSize();
        addToCartPage.AddToCartBtn();
    }

    @Then("success message should appear")
    public void SuccessMessage() throws InterruptedException {
        addToCartPage = new AddToCartPage(base.getDriver());

        String expectedResult = "The product has been added to your";
        String actualResult = addToCartPage.getSuccessMsg().getText();

        Assert.assertTrue(actualResult.contains(expectedResult));
    }

}
