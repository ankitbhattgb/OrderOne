package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	@FindBy(how=How.ID, using="ControlGroupLoginView_MemberLoginView2LoginView_TextBoxUserID")
	public static WebElement userID;

	@FindBy(how=How.ID, using="ControlGroupLoginView_MemberLoginView2LoginView_PasswordFieldPassword")
	public static WebElement password;
	
	@FindBy(how=How.ID, using="ControlGroupLoginView_MemberLoginView2LoginView_ButtonLogIn")
	public static WebElement loginBtn;
	
	@FindBy(how=How.XPATH, using="//label[contains(text(),'Name')]/following-sibling::span")
	public static WebElement userName;
	
	@FindBy(how=How.XPATH, using="//span[contains(text(),'Welcome')]")
	public static WebElement msg;
	
	@FindBy(how=How.XPATH, using="//div[contains(text(),'ALERT')]")
	public static WebElement alertMsg;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Log Out')][1]")
	public static WebElement logout;
	
	@FindBy(how=How.ID, using="Login")
	public static WebElement Login;
}

