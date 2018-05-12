package stepDef;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin={"pretty","html:target/cucumber-html-report"}, strict = true, monochrome = true,
		features= {"src/test/java/stepDef/SpiceJet_Special_Club_Member_login.feature"},
		glue= {"src/test/java/stepDef/SpiceJet_Special_Club_Member_login.java"}		
		)



public class TestRunner {

}
