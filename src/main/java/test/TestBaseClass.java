package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class TestBaseClass {

	public static Properties CONFIG = null;
	public static Properties OR = null;
	public WebDriver dr = null;
	public static EventFiringWebDriver driver;
	public static boolean browserStatus = false;
	public static boolean isLoggedIn = false;
	
	public void initiallize() throws IOException {
		CONFIG = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//resource//java//config//config.properties");
		CONFIG.load(fis);

		OR = new Properties();
		fis = new FileInputStream(System.getProperty("user.dir") + "//src//resource//java//config//or.properties");
		OR.load(fis);

		if (CONFIG.getProperty("brosertype").toUpperCase().equals("FIREFOX")) {
			dr = new FirefoxDriver();
		} else if (CONFIG.getProperty("browsertype").toUpperCase().equals("IE")) {
			dr = new InternetExplorerDriver();
		}
		browserStatus = openBrowser();

	}

	public boolean openBrowser()
	{
		if(!browserStatus)
		{
		driver = new EventFiringWebDriver(dr);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return true;
		}
		else{
			return true;
		}
	}
	public void closeBrowser()
	{
		
			driver.quit();
			browserStatus=false;
		
	}

	public static WebElement getObject(String xpathValue) 
	{
		try {
			return driver.findElement(By.xpath(OR.getProperty(xpathValue)));
		} catch (Throwable t) {
			// report error
			return null;
		}
	}
}
