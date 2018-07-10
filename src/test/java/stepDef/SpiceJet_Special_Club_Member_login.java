package stepDef;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.Scenario;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.Select;
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
	public void setUp() throws IOException
	{	
		String className = this.getClass().getSimpleName();
		driver=baseObj.initializeDriver();
		
		baseObj.initializePDF(className);
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
	}

	@Given("^user is on landing page of spice jet$")
	public void user_is_onlandingpage() throws IOException, AWTException 
	{
		
		System.out.println(scenario);
		driver.get("http://spicejet.com");
		baseObj.addTextToPDF("First Screen");
		String filename=baseObj.takescreenshot();
		baseObj.addImgToPDF(filename);

	}

	@When("^user hovers on Login$")
	public void user_hovers_on_Login() throws IOException, AWTException
	{
		baseObj.customWait(driver, LandingPage.login, 10);		
		baseObj.moveToElement(driver, LandingPage.login);	
		baseObj.addTextToPDF("Second Screen");
		String filename=baseObj.takescreenshot();
		baseObj.addImgToPDF(filename);
	}

	@When("^user hovers on SpiceCash/SpiceClub Members$")
	public void user_hovers_on_SpiceCash() throws IOException, AWTException
	{
		baseObj.customWait(driver, LandingPage.spiceMember, 10);
		baseObj.moveToElement(driver, LandingPage.spiceMember);		
		baseObj.addTextToPDF("Third Screen");
		String filename=baseObj.takescreenshot();
		baseObj.addImgToPDF(filename);
	}

	@When("^user clicks on Member Login$")
	public void user_clicks_on_Member_Login() throws IOException, AWTException
	{
		baseObj.customWait(driver, LandingPage.memberLogin, 10);
		baseObj.moveToElement(driver, LandingPage.memberLogin);
		baseObj.addTextToPDF("Fourth Screen");
		String filename=baseObj.takescreenshot();
		baseObj.addImgToPDF(filename);
		LandingPage.memberLogin.click();
	}

	@When("^user enters userid \"([^\"]*)\"$")
	public void user_enters_userid(String userid) throws IOException, AWTException
	{
		baseObj.customWait(driver, LoginPage.loginBtn, 10);		
		LoginPage.loginBtn.isDisplayed();
		baseObj.addTextToPDF("fifth Screen");
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
		baseObj.addTextToPDF("Sixth Screen");
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
		baseObj.customWait(driver, LoginPage.msg, 10);
		Assert.assertEquals(LoginPage.msg.getText(), "Welcome");
		baseObj.addTextToPDF("Seventh Screen");
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
		baseObj.addTextToPDF("Eighth Screen");
		String filename=baseObj.takescreenshot();
		baseObj.addImgToPDF(filename);

	}

	@When("^user clicks Book link$")
	public void user_clicks_Book_link()
	{
		LandingPage.book.click();
	}

	@Then("^booking page should display$")
	public void booking_page_should_display()
	{
		Assert.assertTrue(LandingPage.depart.isDisplayed());
	}
	@When("^user clicks on oneway radio button$")
	public void user_clicks_on_oneway_radio_button()
	{
		LandingPage.oneway.click();
	}

	@When("^user selects from city \"([^\"]*)\" and to city \"([^\"]*)\"$")
	public void user_selects_from_city(String fromCity, String toCity)
	{
		if(fromCity!=toCity)
		{
			LandingPage.depart.click();
			fromCity = baseObj.singleQuote(fromCity);
			toCity = baseObj.singleQuote(toCity);
			driver.findElement(By.xpath("(//a[contains(text(),"+fromCity+")])[1]")).click();
			driver.findElement(By.xpath("(//a[contains(text(),"+toCity+")])[2]")).click();
		}
		else
		{
			tearDown();	
		}
	}

	@When("^user selects depart date \"([^\"]*)\"$")
	public void user_selects_depart_date(String departDate)
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
			LandingPage.nextMonth.click();
			onScreenDate = LandingPage.onScreenDate.getText();
			result = splitMonth.equalsIgnoreCase(onScreenDate);
		} 
		String elementPath = "//html//*[@data-month="+cMonthNo+"]//a";	
		baseObj.selectday(driver,elementPath,splitDate[0]);
	}

	@When("^user selects no of pax \"([^\"]*)\"$")
	public void user_selects_no_of_pax(int noOfPassanger)
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
			LandingPage.closePaxOpt.click();
		}
	}
	@When("^user selects currency \"([^\"]*)\"$")

	public void user_selects_currency (String currency)
	{
		wait.until(ExpectedConditions.visibilityOf(LandingPage.currency));
		Select sel = new Select(LandingPage.currency);
		LandingPage.currency.click();
		sel.selectByValue(currency);
	}
	@When("^user clicks on search button$")
	public void user_clicks_on_search_button()
	{
		LandingPage.srchFltBtn.click();
	}
	@Then("^search result should display$")
	public void search_result_should_display()
	{
		baseObj.customWait(driver, LandingPage.modifyBtn, 10);
		Assert.assertTrue(LandingPage.modifyBtn.isDisplayed());
	}







}	