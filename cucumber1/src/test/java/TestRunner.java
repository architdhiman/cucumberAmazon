import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", 
					glue = "StepDefinitions", 
					plugin = {"pretty","html:target/cucumber.html"},
					dryRun = false)
public class TestRunner {

}
