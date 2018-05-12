

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin={"pretty","html:target/cucumber-html-report"}, strict = true, monochrome = true
		,features = {"src/test/java"}
		)

public class RunCucumberTest {

}
