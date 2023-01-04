package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    WebElement usernameElement;
    @FindBy(id = "Password")
    WebElement passwordElement;
    @FindBy(className = "message-error")
    public WebElement errorLoginMsg;


    public void loginSteps(String username, String password) {
        usernameElement.sendKeys(username);
        passwordElement.sendKeys(password);
    }

    public void loginBtn() {
        passwordElement.sendKeys(Keys.ENTER);
    }


}
