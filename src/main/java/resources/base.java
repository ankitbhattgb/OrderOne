package resources;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;

import javax.imageio.ImageIO;
public class base 
{
	public WebDriver driver;
	PdfWriter Writer;
	PdfDocument pdf;
	Document document;
	

	/* **************************************  Initialize a WebDriver ************************************** */
	public WebDriver initializeDriver() throws IOException 
	{
		//Getting data file
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Program Files (x86)\\Jenkins\\workspace\\SpiceJet"
				+ "\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);

		String browserName= prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome"))
		{	
			System.setProperty("webdriver.chrome.driver", 
					"C:\\Program Files (x86)\\Jenkins\\workspace\\SpiceJet\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", 
					"C:\\Program Files (x86)\\Jenkins\\workspace\\SpiceJet\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();	
		}
		else if (browserName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", 
					"C:\\Program Files (x86)\\Jenkins\\workspace\\SpiceJet\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if (browserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", 
					"C:\\Program Files (x86)\\Jenkins\\workspace\\SpiceJet\\drivers\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		return driver;
	} 	
	/* *********** return System current date with timestamp and timezone **************************** */	

	public static String currentSystemDateAndTime()
	{
		Date d = new Date();
		String currDate=d.toString();
		currDate=currDate.replace(":", "-");
		return currDate;
	}

	/* *************************************** Return a frame number *************************************** */
//	public int findFrameNumber(WebDriver localDriver, WebElement By.abc)
//	{
//		int i;
//		int frameCount = localDriver.findElements(By.tagName("iframe")).size();
//		for (i=0;i<frameCount;i++)
//		{
//			driver.switchTo().frame(i);
//			int count = localDriver.findElements(By.abc).size();
//			if (count>0)
//			{
//				break;
//			}
//			
//		}
//		localDriver.switchTo().defaultContent();
//		return i;
//	}
	/* *********** below method will move your mouse to particular element on screen **************************** */	

	public void moveToElement(WebDriver localDriver, WebElement elementId) 
	{
		Actions action=new Actions(localDriver);
		action.moveToElement(elementId).perform();
	}

	/* *********** below method will wait for an element to be clickable **************************** */
	//	public void customWait(WebDriver localDriver, WebElement elementID, int w)
	//	{
	//		WebDriverWait wait = new WebDriverWait(localDriver, w);
	//		wait.until(ExpectedConditions.elementToBeClickable(elementID));
	//	}

	/* ****************************************** Initialize a PDF ********************************************* */
	@SuppressWarnings("resource")
	public void initializePDF(String featureName) throws FileNotFoundException
	{
		String filename="C:\\Program Files (x86)\\Jenkins\\workspace\\SpiceJet\\Screenshots\\"
						 +featureName+currentSystemDateAndTime()+".pdf";
		Writer = new PdfWriter(filename);
		pdf= new PdfDocument(Writer);
		document = new Document(pdf);
		document.setMargins(10, 20, 10, 20);
		document.add(new Paragraph(featureName));
	}

	/* ******************************************* Delete files ********************************************** */
	public void deleteFiles(String extn)
	{
		File file = new File("C:\\Program Files (x86)\\Jenkins\\workspace\\SpiceJet\\Screenshots\\");
		File[] files = file.listFiles();
		for(File f: files)
		{
			if (f.getName().endsWith(extn))
			{
				f.delete();
			}
		}	
	}
	/* ******************************************* Add IMG to PDF ********************************************** */
	public void addImgToPDF(String filename) throws MalformedURLException
	{
		Image img= new Image(ImageDataFactory.create(filename));
		document.add(img);
	}

	/* ******************************************* Add Text to PDF ********************************************** */
	public void addTextToPDF(String msg)
	{
		List list = new List()
				.setSymbolIndent(12)
				.setListSymbol("\u2022");
		list.add(new ListItem(msg));
		document.add(list);
	}


	/* ************************************************ Close PDF *********************************************** */	
	public void closePdf()
	{
		document.close();
	}


	/* ******************************** Taking screen shot using WebDriver object ******************************* */
	public String takeScreenshot(WebDriver localDriver) throws IOException
	{	
		String format=".png";
		String filename= "C:\\Program Files (x86)\\Jenkins\\workspace\\SpiceJet\\Screenshots\\"
						  +currentSystemDateAndTime()+format;
		File src = ((TakesScreenshot)localDriver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(filename));
		return filename;
	}

	/* ********************************** Taking screen shot using ROBOT class ********************************** */

	public String  takescreenshot() throws AWTException, IOException
	{
		String format =".png";
		String filename = "C:\\Program Files (x86)\\Jenkins\\workspace\\SpiceJet\\Screenshots\\"
							+currentSystemDateAndTime()+format;
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage screenFullImage = new Robot().createScreenCapture(screenRect);
		ImageIO.write(screenFullImage, "png", new File(filename));
		return filename;
	}

	/* ************************************** Select a day from Calendar ************************************** */
	public void selectday(WebDriver localDriver, String elementPath, String departDay)
	{
		WebElement day = localDriver.findElement(By.xpath(elementPath));
		int count = day.findElements(By.xpath(elementPath)).size();
		for(int i=1;i<=count;i++)
		{
			String dtext= day.findElements(By.xpath(elementPath)).get(i).getText();
			if (dtext.contains(departDay))
			{
				day.findElements(By.xpath(elementPath)).get(i).click();
				break;
			}
		}
	}

	/* ********************************** Add single quote to a string ********************************** */	
	public String singleQuote(String s) {

		return new StringBuilder()
				.append('\'')
				.append(s)
				.append('\'')
				.toString();
	}
	/* ********************************** Add double quote to a string ********************************** */	
	public String doubleQuote(String s) {

		return new StringBuilder()
				.append("\"")
				.append(s)
				.append("\"")
				.toString();
	}

	/* ********************************** convert a month to a numeric value ****************************** */	
	public int getMonthNumber(String str) 
	{
		if (str.equalsIgnoreCase("january"))
		{
			return 1;
		}
		else if (str.equalsIgnoreCase("february"))
		{
			return 2;
		}
		else if (str.equalsIgnoreCase("march"))
		{
			return 3;
		}
		else if (str.equalsIgnoreCase("april"))
		{
			return 4;
		}		
		else if (str.equalsIgnoreCase("may"))
		{
			return 5;
		}
		else if (str.equalsIgnoreCase("june"))
		{
			return 6;
		}
		else if (str.equalsIgnoreCase("july"))
		{
			return 7;
		}
		else if (str.equalsIgnoreCase("august"))
		{
			return 8;
		}
		else if (str.equalsIgnoreCase("september"))
		{
			return 9;
		}
		else if (str.equalsIgnoreCase("october"))
		{
			return 10;
		}
		else if (str.equalsIgnoreCase("november"))
		{
			return 11;
		}
		else if (str.equalsIgnoreCase("december"))
		{
			return 12;
		}
		else if (str.equalsIgnoreCase("jan"))
		{
			return 1;
		}
		else if (str.equalsIgnoreCase("feb"))
		{
			return 2;
		}
		else if (str.equalsIgnoreCase("mar"))
		{
			return 3;
		}
		else if (str.equalsIgnoreCase("apr"))
		{
			return 4;
		}		
		else if (str.equalsIgnoreCase("may"))
		{
			return 5;
		}
		else if (str.equalsIgnoreCase("jun"))
		{
			return 6;
		}
		else if (str.equalsIgnoreCase("jul"))
		{
			return 7;
		}
		else if (str.equalsIgnoreCase("aug"))
		{
			return 8;
		}
		else if (str.equalsIgnoreCase("sep"))
		{
			return 9;
		}
		else if (str.equalsIgnoreCase("oct"))
		{
			return 10;
		}
		else if (str.equalsIgnoreCase("nov"))
		{
			return 11;
		}
		else if (str.equalsIgnoreCase("dec"))
		{
			return 12;
		}
		else 
		{
			return 0;
		}
	}	
}

