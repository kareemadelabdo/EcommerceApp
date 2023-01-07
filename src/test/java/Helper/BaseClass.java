package Helper;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

    private WebDriver driver;
    private LoginPage loginPage;

    public WebDriver getDriver()
    {
        return driver;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public void setDriver()
    {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
}
