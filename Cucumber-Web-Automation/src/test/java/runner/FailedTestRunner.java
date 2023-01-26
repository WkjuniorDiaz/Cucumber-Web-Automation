package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "@target/failed_scenarios.txt",
        glue = {"stepDefinitions"},
        monochrome = true,
        plugin = {
                "pretty",
                "rerun:target/failed_scenarios.txt"
        })
public class FailedTestRunner {
}
