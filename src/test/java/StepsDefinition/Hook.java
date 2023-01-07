package StepsDefinition;

import Helper.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hook {

    WebDriver driver;
    BaseClass base;

    public Hook(BaseClass base)
    {
        this.base = base;
    }

    @Before
    public void OpenBrowser()
    {
        base.setDriver();
    }

    @After
    public void CloseBrowser() throws InterruptedException {
        Thread.sleep(2000);
        base.getDriver().quit();
    }
}
