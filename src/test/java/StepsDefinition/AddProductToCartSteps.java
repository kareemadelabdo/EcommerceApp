package StepsDefinition;

import Pages.AddToCartPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddProductToCartSteps {
    WebDriver driver = null;
    AddToCartPage addToCartPage;


    @Given("user should navigate to website home page")
    public void UserNavigateToLoginPage() {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        addToCartPage = new AddToCartPage(driver);
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @And("user should choose apparel then shoes")
    public void UserChooseItem() {
        addToCartPage.selectSubCategory();
    }

    @When("user should choose color and add shoes to cart and go to cart page to view it")
    public void AddToCart() throws InterruptedException {
        addToCartPage.FirstAddToCart();
        Thread.sleep(2000);
        addToCartPage.ChooseColor();
        addToCartPage.ChooseSize();
        addToCartPage.AddToCartBtn();
    }

    @Then("success message should appear")
    public void SuccessMessage() throws InterruptedException {

        String expectedResult = "The product has been added to your";
        String actualResult = addToCartPage.getSuccessMsg().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

}
