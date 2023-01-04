package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterWithColorPage {
    WebDriver driver;

    public FilterWithColorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "a[href=\"/apparel\"]")
    WebElement hoverEle;
    @FindBy(css = "a[href=\"/shoes\"]")
    WebElement shoesEle;
    @FindBy(id = "attribute-option-16")
    WebElement choosedColor;

    public void selectItem(){
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverEle).perform();
        shoesEle.click();
    }

    public void ChooseColor(){

        choosedColor.click();
    }
}
