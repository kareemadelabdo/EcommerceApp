package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {

    WebDriver driver;

    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[href=\"/apparel\"]")
    WebElement categoryEle;

    @FindBy(css = "a[href=\"/shoes\"]")
    WebElement subCategoryEle;

    @FindBy(css = "button[class=\"button-2 product-box-add-to-cart-button\"]")
    WebElement firstAddToCartEle;

    @FindBy(className = "attribute-square")
    WebElement choosedColor;

    @FindBy(id = "product_attribute_9")
    WebElement sizeList;


    @FindBy(id = "add-to-cart-button-25")
    WebElement addToCartEle;

    @FindBy(css = "p[class=\"content\"]")
    WebElement successMsg;



    public void selectSubCategory() {
        Actions actions = new Actions(driver);
        actions.moveToElement(categoryEle).perform();
        subCategoryEle.click();
    }

    public void FirstAddToCart() {
        firstAddToCartEle.click();
    }

    public void ChooseColor() {
        choosedColor.click();
    }

    public void ChooseSize(){
        sizeList.sendKeys("8");
    }

    public WebElement getSuccessMsg() throws InterruptedException {
        Thread.sleep(2000);
        return successMsg;
    }

    public void AddToCartBtn() throws InterruptedException {
        Thread.sleep(2000);
        addToCartEle.click();
    }
}
