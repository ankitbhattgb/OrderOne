package stepDef;

import java.awt.AWTException;
import cucumber.api.Scenario;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpiceJet_Special_Club_Member_login 
{

	public WebDriver driver;
	base baseObj =new base();
	public WebDriverWait wait;


	@Before
	public void setUp(Scenario scenario) throws IOException
	{	
		String scenarioName = scenario.getName();
		driver=baseObj.initializeDriver();
		baseObj.initializePDF(scenarioName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		PageFactory.initElements(driver, LandingPage.class);
		PageFactory.initElements(driver, LoginPage.class);	
		wait = new WebDriverWait(driver,10);
	}
	@After
	public void tearDown()
	{
		driver.close();
		driver.quit();
		baseObj.closePdf();		
		baseObj.deleteFiles();
		wait=null;
		baseObj=null;
		System.gc();
	}
	@Given("^user is on landing page of spice jet$")
	public void user_is_onlandingpage() throws IOException, AWTException 
	{
		driver.get("http://spicejet.com");
		//baseObj.addTextToPDF("First Screen");
		String filename=baseObj.takescreenshot();
		baseObj.addImgToPDF(filename);

	}

	@When("^user hovers on Login$")
	public void user_hovers_on_Login() throws IOException, AWTException
	{		
		wait.until(ExpectedConditions.elementToBeClickable(LandingPage.login));
		baseObj.moveToElement(driver, LandingPage.login);	
		//baseObj.addTextToPDF("Second Screen");
		String filename=baseObj.takescreenshot();
		baseObj.addImgToPDF(filename);
	}

	@When("^user hovers on SpiceCash/SpiceClub Members$")
	public void user_hovers_on_SpiceCash() throws IOException, AWTException
	{
		wait.until(ExpectedConditions.elementToBeClickable(LandingPage.spiceMember));
		baseObj.moveToElement(driver, LandingPage.spiceMember);		
		//baseObj.addTextToPDF("Third Screen");
		String filename=baseObj.takescreenshot();
		baseObj.addImgToPDF(filename);
	}
	@When("^user clicks on Member Login$")
	public void user_clicks_on_Member_Login() throws IOException, AWTException
	{
		wait.until(ExpectedConditions.elementToBeClickable(LandingPage.memberLogin));
		baseObj.moveToElement(driver, LandingPage.memberLogin);
		//baseObj.addTextToPDF("Fourth Screen");
		String filename=baseObj.takescreenshot();
		baseObj.addImgToPDF(filename);
		LandingPage.memberLogin.click();
	}

	@When("^user enters userid \"([^\"]*)\"$")
	public void user_enters_userid(String userid) throws IOException, AWTException
	{
		wait.until(ExpectedConditions.elementToBeClickable(LoginPage.loginBtn));
		LoginPage.loginBtn.isDisplayed();
		//baseObj.addTextToPDF("fifth Screen");
		String filename=baseObj.takescreenshot();
		baseObj.addImgToPDF(filename);
		LoginPage.userID.clear();
		LoginPage.userID.sendKeys(userid);
	}

	@When("^user enters password \"([^\"]*)\"$")
	public void user_enters_password(String pwd) throws IOException, AWTException
	{		
		LoginPage.password.clear();
		LoginPage.password.sendKeys(pwd);
		//baseObj.addTextToPDF("Sixth Screen");
		String filename=baseObj.takescreenshot();
		baseObj.addImgToPDF(filename);
	}

	@When("^user clicks on Login button$")
	public void user_clicks_on_Login_button()
	{		
		LoginPage.loginBtn.click();
	}

	@Then("^user portal should display with word Welcome$")
	public void user_portal_should_display() throws IOException, AWTException
	{
		wait.until(ExpectedConditions.elementToBeClickable(LoginPage.msg));
		Assert.assertEquals(LoginPage.msg.getText(), "Welcome");
		//baseObj.addTextToPDF("Seventh Screen");
		String filename=baseObj.takescreenshot();
		baseObj.addImgToPDF(filename);
	}

	@When("^user clicks on logout$")
	public void user_clicks_on_logout()
	{
		LoginPage.logout.click();
	}

	@Then("^user should logout$")
	public void user_should_logout() throws IOException, AWTException
	{		
		Assert.assertTrue(LoginPage.Login.isDisplayed());
		//baseObj.addTextToPDF("Eighth Screen");
		String filename=baseObj.takescreenshot();
		baseObj.addImgToPDF(filename);

	}

	@When("^user clicks Book link$")
	public void user_clicks_Book_link() throws AWTException, IOException
	{
		LandingPage.book.click();
		//baseObj.addTextToPDF("First Screen");
		String filename=baseObj.takescreenshot();
		baseObj.addImgToPDF(filename);

	}

	@Then("^booking page should display$")
	public void booking_page_should_display() throws AWTException, IOException
	{
		Assert.assertTrue(LandingPage.depart.isDisplayed());
		//baseObj.addTextToPDF("First Screen");
		String filename=baseObj.takescreenshot();
		baseObj.addImgToPDF(filename);

	}
	@When("^user clicks on oneway radio button$")
	public void user_clicks_on_oneway_radio_button()
	{
		LandingPage.oneway.click();
	}

	@When("^user selects from city \"([^\"]*)\" and to city \"([^\"]*)\"$")
	public void user_selects_from_city(String fromCity, String toCity) throws AWTException, IOException
	{
		if(fromCity!=toCity)
		{
			LandingPage.depart.click();
			fromCity = baseObj.singleQuote(fromCity);
			toCity = baseObj.singleQuote(toCity);
			driver.findElement(By.xpath("(//a[contains(text(),"+fromCity+")])[1]")).click();
			driver.findElement(By.xpath("(//a[contains(text(),"+toCity+")])[2]")).click();
			//baseObj.addTextToPDF("First Screen");
			String filename=baseObj.takescreenshot();
			baseObj.addImgToPDF(filename);

		}
		else
		{
			Assert.fail();
			tearDown();	
		}
	}

	@When("^user selects depart date \"([^\"]*)\"$")
	public void user_selects_depart_date(String departDate) throws AWTException, IOException
	{
		LandingPage.dateBox.click();
		String onScreenDate = LandingPage.onScreenDate.getText(); 
		String[] splitDate = departDate.split(" ");
		String splitMonth=splitDate[1]+" "+splitDate[2];
		int monthNo= baseObj.getMonthNumber(splitDate[1]);
		String cMonthNo = baseObj.singleQuote(String.valueOf(monthNo-1));
		boolean result = splitMonth.equalsIgnoreCase(onScreenDate);
		while(!result)
		{
			wait.until(ExpectedConditions.visibilityOf(LandingPage.nextMonth));
			LandingPage.nextMonth.click();
			onScreenDate = LandingPage.onScreenDate.getText();
			result = splitMonth.equalsIgnoreCase(onScreenDate);
		} 
		String elementPath = "//html//*[@data-month="+cMonthNo+"]//a";	
		baseObj.selectday(driver,elementPath,splitDate[0]);
		//baseObj.addTextToPDF("First Screen");
		String filename=baseObj.takescreenshot();
		baseObj.addImgToPDF(filename);

	}

	@When("^user selects no of pax \"([^\"]*)\"$")
	public void user_selects_no_of_pax(int noOfPassanger) throws AWTException, IOException
	{	
		if (noOfPassanger>1)
		{
			wait.until(ExpectedConditions.invisibilityOf(LandingPage.datePickerBox));
			LandingPage.passengerDropdown.click();
			wait.until(ExpectedConditions.visibilityOf(LandingPage.adult));
			for (int i=1;i<noOfPassanger;i++)
			{
				LandingPage.adult.click();
			}
			//baseObj.addTextToPDF("First Screen");
			String filename=baseObj.takescreenshot();
			baseObj.addImgToPDF(filename);

			LandingPage.closePaxOpt.click();

		}
	}
	@When("^user selects currency \"([^\"]*)\"$")

	public void user_selects_currency (String currency) throws AWTException, IOException
	{
		wait.until(ExpectedConditions.visibilityOf(LandingPage.currency));
		Select sel = new Select(LandingPage.currency);
		LandingPage.currency.click();
		sel.selectByValue(currency);
		//baseObj.addTextToPDF("First Screen");
		String filename=baseObj.takescreenshot();
		baseObj.addImgToPDF(filename);
	}
	@When("^user clicks on search button$")
	public void user_clicks_on_search_button()
	{
		LandingPage.srchFltBtn.click();
	}
	@Then("^search result should display$")
	public void search_result_should_display() throws AWTException, IOException
	{
		wait.until(ExpectedConditions.elementToBeClickable(LandingPage.modifyBtn));
		Assert.assertTrue(LandingPage.modifyBtn.isDisplayed());
		//baseObj.addTextToPDF("First Screen");
		String filename=baseObj.takescreenshot();
		baseObj.addImgToPDF(filename);
	}
}	