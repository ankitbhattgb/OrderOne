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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

	@SuppressWarnings("resource")
	public void initializePDF(String featureName) throws FileNotFoundException
	{
		String filename="D:\\"+featureName+".pdf";
		Writer = new PdfWriter(filename);
		pdf= new PdfDocument(Writer);
		document = new Document(pdf);

		document.setMargins(20, 20, 20, 20);
		document.add(new Paragraph(featureName));
	}

	public void addImgToPDF(String filename) throws MalformedURLException
	{
		Image img= new Image(ImageDataFactory.create(filename));
		document.add(img);
	}

	public void addTextToPDF(String msg)
	{
		List list = new List()
				.setSymbolIndent(12)
				.setListSymbol("\u2022");
		list.add(new ListItem(msg));
		document.add(list);
	}
	
	public void closePdf()
	{
		document.close();
	}

	public String takeScreenshot(WebDriver localDriver) throws IOException
	{	
		String format=".png";
		String filename= "D:\\"+(System.currentTimeMillis())+format;
		File src = ((TakesScreenshot)localDriver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(filename));
		return filename;
	}


	public String  takescreenshot() throws AWTException, IOException
	{
		String format =".png";
		String filename = "D:\\"+(System.currentTimeMillis())+format;
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage screenFullImage = new Robot().createScreenCapture(screenRect);
		ImageIO.write(screenFullImage, "png", new File(filename));
		return filename;
	}
}

