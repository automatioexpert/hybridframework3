package com.learnautomation.helper;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.learnautomation.dataprovider.ConfigReader;
import com.learnautomation.factory.BrowserFactory;

public class BaseClass {

	// make report object static
	public static ExtentReports report;
	public WebDriver driver;
	public ExtentTest logger;

	@BeforeSuite
	public void setupReport()
	{
		System.out.println("LOG:INFO- Setting up the report");
		
		//ExtentSparkReporter sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/AutomationReport"+Utility.getCurrentTime()+".html");

		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/AutomationReport.html");
		
		sparkReporter.config().setDocumentTitle("Automation Report");
		
		sparkReporter.config().setReportName("Test Automation Report Sprint 2");
	
		sparkReporter.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		
		report.attachReporter(sparkReporter);
		
		System.out.println("LOG:INFO- Report is set and ready to use");
		
	}
	
	@Parameters({"Browser","URL"})
	@BeforeClass
	public void startSession(String browser,String url)
	{
		System.out.println("LOG:INFO- Setting up the Browser "+browser +" "+url);
		
		//driver=BrowserFactory.startApplication(new ConfigReader().getValue("Browser"),new ConfigReader().getValue("stagingURL"));
		
		driver=BrowserFactory.startApplication(browser,url);

		
		System.out.println("LOG:INFO- Browser and Application is up and running");
	}
	
	
	@AfterClass
	public void closeSession()
	{
		driver.quit();
		System.out.println("LOG:INFO- Browser terminated");
	}
	
	
	@AfterMethod
	public void tearDownReport(ITestResult result)
	{
		System.out.println("LOG:INFO- Capturing Test Result ");
		
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			System.out.println("LOG:PASS- Test Passed");
			try 
			{
				logger.pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
			} catch (IOException e) {
				System.out.println("Could not attach screenshot in the report");
			}
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			System.out.println("LOG:FAIL- Test Failed "+result.getThrowable().getMessage());
			
			try 
			{
				logger.fail("Test Failed "+result.getThrowable().getMessage(),
				MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
			} catch (IOException e) {
				
				System.out.println("Could not attach screenshot in the report");
			}
		}
		
		report.flush();
		System.out.println("LOG:INFO- Report is generated");
	}
	
}
