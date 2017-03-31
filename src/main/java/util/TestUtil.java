package util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import test.TestBaseClass;

public class TestUtil extends TestBaseClass {

	
	public void doLogin(String Username, String Password) throws InterruptedException	
	{
		driver.get(CONFIG.getProperty("testURLLInk"));
		if (!driver.getTitle().equals("Login")) {
			dologout();
		}
		//if the user is not logged in 
			
		getObject("sign-In-EmailId-xpath").sendKeys(Username);		
		getObject("sign-In-Passwod-Xpath").sendKeys(Password);	
		getObject("sigin-In-Button").click();
		Thread.sleep(3000L);
		//System.out.println("after login"+driver.getTitle());
			
			if(!driver.getTitle().equals("Login"))
			{
				System.out.println("logged in successfully");
				isLoggedIn=true;
			}else {
				System.out.println("Login Failed");
				isLoggedIn=false;
			}
			 
		
	}
	
	
	
	public void dologout() throws InterruptedException
	{
			Actions actions=new Actions(driver);
			actions.moveToElement(getObject("sign-Out-Button")).perform();;
			List<WebElement> ele=driver.findElements(By.xpath("//a[text()='Sign Out']"));
			ele.get(1).click();
			Thread.sleep(2000);
			isLoggedIn=false;
		
	}

}
