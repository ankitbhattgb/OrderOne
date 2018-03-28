package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Basictest 
{

	@Given("I work in \"([^\"]*)\"")
	public void gn(String str)
	{
		if(str.equals("morning"))
		{
			System.out.println("morning");
		}
		if(str.equals("noon"))
		{
			System.out.println("noon");
		}
		if(str.equals("evening"))
		{
			System.out.println("evening");
		}
		if(str.equals("night"))
		{
			System.out.println("night");
		}
	}

	@When("I meet \"([^\"]*)\"")
	public void wn(String str)
	{
		if(str.equals("officeboy"))
		{
			System.out.println("OfficeBoy");
		}
		if(str.equals("newspaperboy"))
		{
			System.out.println("NewsPaperBoy");
		}
		if(str.equals("cabdriver"))
		{
			System.out.println("CabDriver");
		}
		if(str.equals("security"))
		{
			System.out.println("SecuityGuard");
		}
	}	

	@Then("I \"([^\"]*)\" him")
	public void tn(String str)
	{
		if(str.equals("greet"))
		{
			System.out.println("I greet officeboy");
		}
		if(str.equals("skipgreeting"))
		{
			System.out.println("I do not greet newspaperboy");
		}
		if(str.equals("handshake"))
		{
			System.out.println("I handshake cabdriver");
		}
		if(str.equals("hug"))
		{
			System.out.println("I hug securityGuard");
		}
	}	


}