package Runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        monochrome = true,
        features = "src\\main\\resources\\Features",
        glue = "StepsDefinition",
        tags = "@login",
        plugin = {"json:target/cucumber.json"}
)

public class TestRunner {

}
