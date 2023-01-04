package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectTagsPage {

    WebDriver driver;

    public SelectTagsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[href=\"/awesome\"]")
    WebElement choosedTag;

    @FindBy(className = "page-title")
    WebElement result;

    public void ClickOnTag(){
        choosedTag.click();
    }

    public WebElement getResult() {
        return result;
    }
}
