package BFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class mainPage { 
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(mainPage.class.getName());
	
	public WebDriver initializeDriver() throws IOException
	{
		
		String mainBrowser = System.getProperty("browser");
		
		if(mainBrowser.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\myjars\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if(mainBrowser.contains("headless"))
				{
					options.addArguments("headless");
				}
			
			driver = new ChromeDriver(options);
			
				
		}
		
		else if(mainBrowser.equalsIgnoreCase("firefox")) 
		{
			//firefox code
		}
		
		log.info("Driver is initialized");
		driver.get(getURL());
		return driver;
	}
	
	
	public String getURL() throws IOException
	{
		
		String mainURL = readProperties("URL");
		log.info("Navigated to home page");
		return mainURL;
	}
	
	public String readProperties(String property) throws IOException
	{
		Properties prop = new Properties(); 
		FileInputStream mainDataFIS = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\mainData.properties");
		prop.load(mainDataFIS);
		String p = prop.getProperty(property);
		return p;
	}
	
	public String screenshot(String testCaseName, WebDriver driver) throws IOException
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH.mm.ss");
		String timestamp  = dateFormat.format(new Date());
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir")+ "//src//main//java//Resources//Screenshots//"+timestamp+" " +testCaseName+" fail.png";
		FileUtils.copyFile(src, new File(screenshotPath));
		return screenshotPath;
		}
		
		
	
	
	

}
