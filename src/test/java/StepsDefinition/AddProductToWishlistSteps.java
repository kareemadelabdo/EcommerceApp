package StepsDefinition;

import Helper.BaseClass;
import Pages.AddToCartPage;
import Pages.AddToWishlistPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddProductToWishlistSteps {


    WebDriver driver;
    AddToWishlistPage addToWishlistPage;

    BaseClass base;

    public AddProductToWishlistSteps(BaseClass base) {
        this.base = base;
    }


    @And("user choose apparel then shoes")
    public void UserChooseSubCategoryItem() {
        base.getDriver().navigate().to("https://demo.nopcommerce.com/");
        addToWishlistPage = new AddToWishlistPage(base.getDriver());
        addToWishlistPage.selectSubCategory();
    }

    @When("user should choose color then add shoes to cart and go to cart page to view it")
    public void AddToWishlist() throws InterruptedException {
        addToWishlistPage = new AddToWishlistPage(base.getDriver());
        addToWishlistPage.FirstAddToCart();
        Thread.sleep(2000);
        addToWishlistPage.ChooseColor();
        addToWishlistPage.ChooseSize();
        addToWishlistPage.AddToWishlistBtn();
    }

    @Then("wishlist success message should appear")
    public void WishlistSuccessMessage() throws InterruptedException {

        addToWishlistPage = new AddToWishlistPage(base.getDriver());
        String expectedResult = "The product has been added to your";
        String actualResult = addToWishlistPage.getSuccessMsg().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

}
