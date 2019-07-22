package runnerClasses;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty",
       "html:target/cucumberHtmlReport",
       "json:target/cucumber-report.json"
   }, 
    features = {
        "src/test/resources/Features"
    },
    glue = {
        "glueCode"
    },
    tags = {
        "@API_Test"
    }
		)
public class CukeRunner {
	
}