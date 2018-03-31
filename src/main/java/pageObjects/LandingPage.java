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
}
