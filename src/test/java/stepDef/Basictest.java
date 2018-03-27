package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Basictest 
{

	@When("^I meet([^\"]*)$")
	public void Imeet(String str) 
	{
		if (str.equals("watchmen"))
		{
			System.out.println("I greet him");
		}
		if (str.equals("newspaperboy"))
		{
			System.out.println("I do not greet him");
		}

	}

	@Given("^I work in ([^\"]*)$")
	public void in(String str)
	{
		if (str.equals("latenight"))
		{
			System.out.println("LN");
		}
		if (str.equals("morning"))
		{
			System.out.println("Morning");
		}
	}
	@Then ("^I ([^\\\"]*) him$")
		public void gre(String str)
		{
			if (str.equals("greet"))
			{
				System.out.println("I greet him");
			}
			if (str.equals("skipgreeting"))
			{
				System.out.println("I do not greet him");
			}

		}
}