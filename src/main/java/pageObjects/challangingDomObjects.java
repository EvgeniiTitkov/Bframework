package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class challangingDomObjects { 
	
	public WebDriver driver;
	
	 
	By blueButton = By.xpath("//body/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]");
	
	
	public challangingDomObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}


	public WebElement blueButton()
	{
		return driver.findElement(blueButton);
	}


}
