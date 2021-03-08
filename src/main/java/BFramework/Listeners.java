package BFramework;

import java.io.IOException;

import org.openqa.selenium.*;
import org.testng.*;
import com.aventstack.extentreports.*;


import Resources.ExtentReporterNG;

public class Listeners extends mainPage implements ITestListener{
	
	ExtentReports extent=ExtentReporterNG.getReportObject();
	ExtentTest test;
	ThreadLocal <ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	public void onFinish(ITestContext result) {
		// TODO Auto-generated method stub
		extent.flush();
	}

	public void onStart(ITestContext result) {
		// TODO Auto-generated method stub
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//extent report fail report
		extentTest.get().fail(result.getThrowable());
		
		// ScreenshotCapture
		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {

		}

		try {
			extentTest.get().addScreenCaptureFromPath(screenshot(result.getName(), driver), result.getName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getName());
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//extent reports success report
		extentTest.get().log(Status.PASS, "Test Passed");
	}

}
