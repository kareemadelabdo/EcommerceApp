package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SwitchCurrenciesPage {

    WebDriver driver;

    public SwitchCurrenciesPage(WebDriver driver) {
        this.driver = driver;
//        PageFactory.initElements(driver, this);
    }

    public void setCurrencyToEuro() {

        WebElement currency = driver.findElement(By.id("customerCurrency"));
        Select select = new Select(currency);
        select.selectByVisibleText("Euro");
    }

    public void setCurrencyToDollar() {

        WebElement currency = driver.findElement(By.id("customerCurrency"));
        Select select = new Select(currency);
        select.selectByVisibleText("US Dollar");
    }

//    @FindBy(id = "customerCurrency")
//    public WebElement currencyEle;


    //
//    Select dropcurrency = new Select(currencyEle);
//
////    Select dropCurrency = new Select(currencyEle);
////


}
