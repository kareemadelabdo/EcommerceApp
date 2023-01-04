package StepsDefinition;

import Pages.AddToCartPage;
import Pages.AddToWishlistPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddProductToWishlistSteps {


    WebDriver driver = null;
    AddToWishlistPage addToWishlistPage;
    @Given("user should go to website homepage")
    public void UserNavigateToWebsite() {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        addToWishlistPage = new AddToWishlistPage(driver);
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/");
    }
    @And("user choose apparel then shoes")
    public void UserChooseSubCategoryItem() {
        addToWishlistPage.selectSubCategory();
    }

    @When("user should choose color then add shoes to cart and go to cart page to view it")
    public void AddToWishlist() throws InterruptedException {
        addToWishlistPage.FirstAddToCart();
        Thread.sleep(2000);
        addToWishlistPage.ChooseColor();
        addToWishlistPage.ChooseSize();
        addToWishlistPage.AddToWishlistBtn();
    }

    @Then("wishlist success message should appear")
    public void WishlistSuccessMessage() throws InterruptedException {

        String expectedResult = "The product has been added to your";
        String actualResult = addToWishlistPage.getSuccessMsg().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
