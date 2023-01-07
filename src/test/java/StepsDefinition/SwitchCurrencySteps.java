package StepsDefinition;

import Helper.BaseClass;
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

    WebDriver driver;
    SwitchCurrenciesPage switchCurrenciesPage;

    BaseClass base;

    public SwitchCurrencySteps(BaseClass base) {
        this.base = base;
    }

    @Given("user change currency from dollar to euro")
    public void ChangeCurrency() {
        base.getDriver().navigate().to("https://demo.nopcommerce.com/");
        switchCurrenciesPage = new SwitchCurrenciesPage(base.getDriver());
        switchCurrenciesPage.setCurrencyToEuro();
        switchCurrenciesPage.setCurrencyToDollar();
    }


}
