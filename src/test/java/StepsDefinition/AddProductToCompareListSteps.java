package StepsDefinition;

import Pages.AddToCompareListPage;
import Pages.AddToWishlistPage;
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
    @Given("user should go to website homepage website")
    public void UserNavigateToLoginPage() {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        addToCompareListPage = new AddToCompareListPage(driver);
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/");
    }
    @And("user choose apparel then shoes item")
    public void UserChooseItem() {
        addToCompareListPage.selectSubCategory();
    }

    @When("user should choose color then add shoes to comparelist")
    public void AddToWishlist() throws InterruptedException {
        addToCompareListPage.FirstAddToCart();
        Thread.sleep(2000);
        addToCompareListPage.ChooseColor();
        addToCompareListPage.ChooseSize();
        addToCompareListPage.AddToComparelistBtn();
    }

    @Then("comparelist success message should appear")
    public void WishListSuccessMessage() throws InterruptedException {

        String expectedResult = "The product has been added to your ";
        String actualResult = addToCompareListPage.getSuccessMsg().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
