package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "page-title")
    public WebElement searchTitleElement;
    @FindBy(id = "small-searchterms")
    public WebElement searchTfElement;
    @FindBy(className = "warning")
    public WebElement errorSerchMsg;
}
