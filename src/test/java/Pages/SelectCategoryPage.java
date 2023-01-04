package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SelectCategoryPage {

    WebDriver driver;

    public SelectCategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[href=\"/computers\"]")
    WebElement categoryEle;
    @FindBy(css = "a[href=\"/digital-downloads\"]")
    WebElement downloadsCategoryEle;
    @FindBy(css = "a[href=\"/desktops\"]")
    WebElement subCategoryEle;

    @FindBy(className = "current-item")
    WebElement result;
    public void selectSubCategory() {
        Actions actions = new Actions(driver);
        String x = categoryEle.getText();
        actions.moveToElement(categoryEle).perform();
        subCategoryEle.click();
    }
    public void selectCategory() {
        downloadsCategoryEle.click();
    }

    public WebElement getResult() {
        return result;
    }
}
