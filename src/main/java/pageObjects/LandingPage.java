package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LandingPage {
	@FindBy(how=How.ID, using="ctl00_HyperLinkLogin")
	public static WebElement login;

	@FindBy(how=How.XPATH, using="//a[contains(text(),'SpiceCash/SpiceClub Members')]")
	public static WebElement spiceMember;

	@FindBy(how=How.XPATH,using="//a[contains(text(),'SpiceCash/SpiceClub Members')]/ancestor::li[1]//a[contains(text(),'Member Login')]")
	public static WebElement memberLogin;
	
	@FindBy(how=How.ID, using="highlight-book")
	public static WebElement book; 

	@FindBy(how=How.ID, using="ctl00_mainContent_rbtnl_Trip_0")
	public static WebElement oneway;
	
	@FindBy(how=How.ID, using="ctl00_mainContent_ddl_originStation1_CTXT")
	public static WebElement depart;
	
	@FindBy(how=How.ID, using="ctl00_mainContent_ddl_destinationStation1_CTXT")
	public static WebElement destination;

	@FindBy(how=How.ID, using="ctl00_mainContent_view_date1")
	public static WebElement dateBox;
	
	@FindBy(how=How.XPATH, using="//a[@title='Prev']/following-sibling::div")
	public static WebElement onScreenDate;
	
	@FindBy(how=How.XPATH, using="//a[@title='Next']")
	public static WebElement nextMonth;

	@FindBy(how=How.ID, using="divpaxinfo")
	public static WebElement passengerDropdown;
	
	@FindBy(how=How.ID, using="hrefIncAdt")
	public static WebElement adult;
	
	@FindBy(how=How.ID, using="btnclosepaxoption")
	public static WebElement closePaxOpt;
	
	@FindBy(how=How.ID,using="ctl00_mainContent_DropDownListCurrency")
	public static WebElement currency;

	@FindBy(how=How.ID,using="ctl00_mainContent_btn_FindFlights")
	public static WebElement srchFltBtn;

	@FindBy(how=How.XPATH,using="//span[@class='trip-modify-btn']")
	public static WebElement modifyBtn;	
	
	@FindBy(how=How.XPATH,using="//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-left']")
	public static WebElement datePickerBox;		

}
