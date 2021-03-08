package BFramework;

import java.io.IOException;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;


import pageObjects.mainPageObjects;



public class mainPageTest extends mainPage {
	mainPageObjects mPO;
	public WebDriver driver;
	
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
	public void basePageTitle() throws IOException
	{
		
		
		String title = driver.getTitle();
		Assert.assertTrue(title.equals("The Internet"));
		Assert.assertEquals(title,"The Internet");
	}
	
	@Test
	public void basicAuthRedirect() throws IOException
	{
		
		mPO.basicAuthLink();
		String title = driver.getTitle();
		System.out.println(title);
		//Assert.assertTrue();
	}

}
