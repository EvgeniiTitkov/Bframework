package BFramework;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.challangingDomObjects;
import pageObjects.mainPageObjects;

public class challengingDomTest extends mainPage {
	
	public WebDriver driver;
	mainPageObjects mPO;

 
	
	@BeforeMethod
	public void initialDriver() throws IOException
	{
		driver = initializeDriver();
		mPO = new mainPageObjects(driver);
		
		
	}
	
	@AfterMethod
	public void closeDriver() 
	{
		driver.close();
	}
	
	@Test
	public void blueButton()
	{
		mPO.challangingDomLink().blueButton().click();
		Assert.assertTrue(false);
		
	}
}
