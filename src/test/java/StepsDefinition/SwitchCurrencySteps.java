package StepsDefinition;

import Pages.LoginPage;
import Pages.SearchPage;
import Pages.SwitchCurrenciesPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SwitchCurrencySteps {

    WebDriver driver = null;
    SwitchCurrenciesPage switchCurrenciesPage;

    @Given("navigate to website")
    public void UserNavigateToLoginPage() {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        switchCurrenciesPage = new SwitchCurrenciesPage(driver);

        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @When("user change currency from dollar to euro")
    public void ChangeCurrency() {

        switchCurrenciesPage.setCurrencyToEuro();
        switchCurrenciesPage.setCurrencyToDollar();
    }


}
