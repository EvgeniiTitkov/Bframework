package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class mainPageObjects {
	
	public WebDriver driver;
	public mainPageObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	 
	By basicAuthLink = By.linkText("Basic Auth");
	By challangingDomLink = By.linkText("Challenging DOM");
	By formAuthLink = By.linkText("Form Authentication");
	


	public WebElement basicAuthLink()
	{
		return driver.findElement(basicAuthLink);
	}
	
	public challangingDomObjects challangingDomLink()
	{
		driver.findElement(challangingDomLink).click();
		challangingDomObjects cDO = new challangingDomObjects(driver);
		return cDO;
	}
	
	public loginPageObjects formAuthLink()
	{
		driver.findElement(formAuthLink).click();
		loginPageObjects lPO = new loginPageObjects(driver);
		return lPO;
	}


}
