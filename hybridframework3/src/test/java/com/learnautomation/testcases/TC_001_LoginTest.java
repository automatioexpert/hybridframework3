package com.learnautomation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.learnautomation.dataprovider.ExcelReader;
import com.learnautomation.helper.BaseClass;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.pages.LogoutPage;

public class TC_001_LoginTest extends BaseClass {
	

	@Test(priority=0)
	public void loginAsAdmin()
	{
		logger=report.createTest("Login Test");
		
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		
		login.loginToApplication(new ExcelReader().getCellData("Login",0,0), new ExcelReader().getCellData("Login",0,1));
		
		logger.info("User is able to login");
		
	}
	
	@Test(priority=1,dependsOnMethods="loginAsAdmin")
	public void logoutFromApplication()
	{
		logger=report.createTest("Logout Test");
	
		LogoutPage logout=PageFactory.initElements(driver, LogoutPage.class);
		
		logout.logoutFromApplication();
		
	}
	
	
	


}
