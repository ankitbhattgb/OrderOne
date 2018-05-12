package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;


public class base {
	public WebDriver driver;


	public WebDriver initializeDriver() throws IOException 
	{
		//Getting data file
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\OrderOne\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);

		String browserName= prop.getProperty("browser");
		if (browserName.equals("chrome"))
		{	
			System.setProperty("webdriver.chrome.driver", "D://Drivers//chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D://Drivers//geckodriver.exe");
			driver = new FirefoxDriver();	
		}
		else if (browserName.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", "D://Drivers//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if (browserName.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", "D://Drivers//MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		return driver;
	} 	


	/*below method will move your mouse to particular element on screen */	

	public void moveToElement(WebDriver localDriver, WebElement elementId) 
	{
		Actions action=new Actions(localDriver);
		action.moveToElement(elementId).perform();
	}
	
	public void customWait(WebDriver localDriver, WebElement elementID, int w)
	{
		WebDriverWait wait = new WebDriverWait(localDriver, w);
		wait.until(ExpectedConditions.elementToBeClickable(elementID));

	}
}
