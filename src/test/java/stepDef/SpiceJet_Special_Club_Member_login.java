package stepDef;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import pageObjects.LandingPage;
import resources.base;

public class SpiceJet_Special_Club_Member_login 
{

	public WebDriver driver;
	base baseObj =new base();
	

	@Before
	public void before() throws IOException
	{
		
		driver=baseObj.initializeDriver();
		driver.manage().window().maximize();
		driver.get("http://spicejet.com");	
		PageFactory.initElements(driver, LandingPage.class);
	}

//	@After
//	public void after()
//	{
//		driver.close();
//		driver.quit();
//	}

	@Given("I am on landing page of spice jet")
	public void one34() 
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		baseObj.customWait(driver, LandingPage.login, 10);		
		baseObj.moveToElement(driver, LandingPage.login);
		baseObj.customWait(driver, LandingPage.spiceMember, 10);
		baseObj.moveToElement(driver, LandingPage.spiceMember);		
		baseObj.customWait(driver, LandingPage.memberLogin, 10);
		baseObj.moveToElement(driver, LandingPage.memberLogin);
		LandingPage.memberLogin.click();		
	}

}
