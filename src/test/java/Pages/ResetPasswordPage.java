package Pages;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage {

    WebDriver driver;

    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    public WebElement emailElement;

    @FindBy(css = "p[class=\"content\"]")
    public WebElement successMessage;

    @FindBy(id = "Email-error")
    public WebElement emptyEmailError;

    @FindBy(css = "p[class=\"content\"]")
    public WebElement wrongEmailError;
    @FindBy(id = "Email-error")
    public WebElement emailFormatError;



}
