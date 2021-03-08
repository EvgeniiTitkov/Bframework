package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPageObjects { 
	
	public WebDriver driver;
	
	 
	private By usernameTextBox = By.xpath("//input[@name='username']");
	private By passwordTextBox = By.xpath("//input[@name='password']");
	private By loginButton = By.xpath("//button[@class='radius']");
	private By successLabel = By.xpath("//h4[@class='subheader']");
	
	
	public loginPageObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}


	public WebElement usernameTextBox()
	{
		return driver.findElement(usernameTextBox);
	} 
	
	public WebElement passwordTextBox()
	{
		return driver.findElement(passwordTextBox);
	}

	public WebElement loginButton()
	{
		return driver.findElement(loginButton);
	}
	
	public WebElement successLabel()
	{
		return driver.findElement(successLabel);
	}



}
