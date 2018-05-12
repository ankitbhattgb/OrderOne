package stepDef;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class SpiceJet_Special_Club_Member_loginFail 
{

	public WebDriver driver;
	base baseObj =new base();

	@Before
	public void setUp() throws IOException
	{
		driver=baseObj.initializeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		PageFactory.initElements(driver, LandingPage.class);
		PageFactory.initElements(driver, LoginPage.class);
	}

	@After
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}

	@Given("^user is on landing page of spice jet$")
	public void user_is_onlandingpage() 
	{
		driver.get("http://spicejet.com");	
	}
	@When("^user hovers on Login$")
	public void user_hovers_on_Login()
	{
		baseObj.customWait(driver, LandingPage.login, 10);		
		baseObj.moveToElement(driver, LandingPage.login);
	}

	@When("^user hovers on SpiceCash/SpiceClub Members$")
	public void user_hovers_on_SpiceCash()
	{
		baseObj.customWait(driver, LandingPage.spiceMember, 10);
		baseObj.moveToElement(driver, LandingPage.spiceMember);		
	}

	@When("^user clicks on Member Login$")
	public void user_clicks_on_Member_Login()
	{
		baseObj.customWait(driver, LandingPage.memberLogin, 10);
		baseObj.moveToElement(driver, LandingPage.memberLogin);
		LandingPage.memberLogin.click();
	}

	@When("^user enters userid \"([^\"]*)\"$")
	public void user_enters_userid(String userid)
	{
		baseObj.customWait(driver, LoginPage.loginBtn, 10);		
		LoginPage.loginBtn.isDisplayed();
		LoginPage.userID.clear();
		LoginPage.userID.sendKeys(userid);
	}

	@When("^user enters password \"([^\"]*)\"$")
	public void user_enters_password(String pwd)
	{		
		LoginPage.password.clear();
		LoginPage.password.sendKeys(pwd);
	}

	@When("^user clicks on Login button$")
	public void user_clicks_on_Login_button()
	{		
		LoginPage.loginBtn.click();
	}
	@Then("^Alert message should display$")
	public void Alert_message_should_display()
	{
		baseObj.customWait(driver, LoginPage.alertMsg, 10);
		Assert.assertTrue(LoginPage.alertMsg.isDisplayed());
		
	}
}

