package stepDef;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class SpiceJet_Special_Club_Member_login 
{

	public WebDriver driver;
	base baseObj =new base();

	@Before
	public void setUp() throws IOException
	{
		driver=baseObj.initializeDriver();
	}

	//	@After
	//	public void tearDown()
	//	{
	//		driver.close();
	//		driver.quit();
	//	}

	@Given("^user is on on landing page of spice jet$")
	public void LandingPage() 
	{
		driver.manage().window().maximize();
		driver.get("http://spicejet.com");		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		PageFactory.initElements(driver, LandingPage.class);
	}

	@When("^user hovers on Login$")
	public void clickOnLogin()
	{
		baseObj.customWait(driver, LandingPage.login, 10);		
		baseObj.moveToElement(driver, LandingPage.login);
	}

	@When("^user hovers on SpiceCash/SpiceClub Members$")
	public void clickOnSpecial()
	{
		baseObj.customWait(driver, LandingPage.spiceMember, 10);
		baseObj.moveToElement(driver, LandingPage.spiceMember);		
	}

	@When("^user clicks on Member Login$")
	public void clickOnMemberLogin()
	{
		baseObj.customWait(driver, LandingPage.memberLogin, 10);
		baseObj.moveToElement(driver, LandingPage.memberLogin);
		LandingPage.memberLogin.click();		
	}

	@When("^user enters userid \"([^\"]*)\"$")
	public void enterUserID(String userid)
	{
		PageFactory.initElements(driver, LoginPage.class);
		baseObj.customWait(driver, LoginPage.loginBtn, 10);		
		LoginPage.loginBtn.isDisplayed();
		LoginPage.userID.clear();
		LoginPage.userID.sendKeys(userid);
	}

	@When("^user enters password \"([^\"]*)\"$")
	public void enterPassword(String pwd)
	{		
		LoginPage.password.clear();
		LoginPage.password.sendKeys(pwd);
	}

	@When("^user clicks on Login button$")
	public void clickLogin()
	{		
		LoginPage.loginBtn.click();
	}
	@Then("^user portal should display with word Welcome$")
	public void userPortal()
	{
		baseObj.customWait(driver, LoginPage.msg, 10);		
	}
}

