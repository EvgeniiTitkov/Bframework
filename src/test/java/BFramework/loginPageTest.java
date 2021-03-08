package BFramework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.loginPageObjects;
import pageObjects.mainPageObjects;


public class loginPageTest extends mainPage {
	
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
	
	@Test(dataProvider="getNamePass",dataProviderClass = loginPage.class)
	public void login(String username, String password, String expectedResult)
	{
		loginPageObjects lPO = mPO.formAuthLink();
		lPO.usernameTextBox().sendKeys(username);
		lPO.passwordTextBox().sendKeys(password);
		lPO.loginButton().click();
		System.out.println(lPO.successLabel().getText());
		if(expectedResult.equals("false"))
		{
			
			Assert.assertTrue(lPO.successLabel().getText().equalsIgnoreCase("This is where you can log into the secure area. Enter tomsmith for the username and SuperSecretPassword! for the password. If the information is wrong you should see error messages."));
			log.info("Assert: Unable to login with wrong credentials. Passed.");
		}
		if(expectedResult.equals("true"))
		{
		
			Assert.assertTrue(lPO.successLabel().getText().equalsIgnoreCase("Welcome to the Secure Area. When you are done click logout below."));
			log.info("Assert: Able to login with wrong credentials. Passed.");
		}
		
	}
	
	
}
