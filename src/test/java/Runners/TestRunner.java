package Runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        monochrome = true,
        features = "src\\main\\resources\\Features",
        glue = "StepsDefinition",
        tags = "@filterWithColor",
        plugin = {"json:target/cucumber.json"}
)

public class TestRunner {

}
