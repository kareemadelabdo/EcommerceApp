package StepsDefinition;

import Pages.AddToCartPage;
import Pages.CreateSuccessfulOrderPage;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrderSteps {

    WebDriver driver = null;
    CreateSuccessfulOrderPage createSuccessfulOrderPage;
    LoginPage loginPage;
    AddToCartPage addToCartPage;

    @Given("user should open website")
    public void OpenWebsite() {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);

        driver = new ChromeDriver();
        createSuccessfulOrderPage = new CreateSuccessfulOrderPage(driver);
        loginPage = new LoginPage(driver);
        addToCartPage = new AddToCartPage(driver);
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
    }

    @And("user should login with valid credentials")
    public void LoginWithValidCredentials() {
        loginPage.loginSteps("kareem@outlook.com", "asdzxc");
        loginPage.loginBtn();
    }



    @And("user should choose apparel shoes item then add to cart")
    public void AddToCart() throws InterruptedException {
        addToCartPage.selectSubCategory();
        addToCartPage.FirstAddToCart();
        Thread.sleep(2000);
        addToCartPage.ChooseColor();
        addToCartPage.ChooseSize();
        addToCartPage.AddToCartBtn();
    }

    @And("user should navigate to shopping cart page and checkout")
    public void Checkout() throws InterruptedException {
        createSuccessfulOrderPage.ClickOnCartLable();
        createSuccessfulOrderPage.AgreeOnTerms();
        createSuccessfulOrderPage.CheckOut();
    }

    @And("user should fill data and press continue")
    public void FillData() throws InterruptedException {
        createSuccessfulOrderPage.SendData();
    }

    @And("user should choose shipping method")
    public void ShippingMethod() throws InterruptedException {
        Thread.sleep(2000);
        createSuccessfulOrderPage.ChooseShipping();
    }

    @And("user should choose payment method and then choose continue")
    public void PaymentMethod() throws InterruptedException {
        Thread.sleep(2000);
        createSuccessfulOrderPage.ChoosePayment();
    }

    @And("user should see payment info")
    public void ConfirmInfo() throws InterruptedException {
        Thread.sleep(2000);
        createSuccessfulOrderPage.PaymentInfo();
    }

    @And("user should confirm order")
    public void ConfirmOrder() throws InterruptedException {
        Thread.sleep(2000);
        createSuccessfulOrderPage.ConfirmOrder();
    }

    @Then("success message should appear stating that order is processed")
    public void SuccessOrderMessage() throws InterruptedException {
        Thread.sleep(2000);

        String expectedResult="Your order has been successfully processed!";
        String actualResult = createSuccessfulOrderPage.getSuccessMsgEle().getText();
        Assert.assertEquals(expectedResult,actualResult);
    }















}
