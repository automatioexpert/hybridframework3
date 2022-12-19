package com.learnautomation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.learnautomation.dataprovider.ExcelReader;
import com.learnautomation.helper.BaseClass;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.pages.LogoutPage;
import com.learnautomation.pages.User;

public class TC_002_RegistrationTest extends BaseClass {
	

	@Test(priority=0)
	public void loginAsAdmin()
	{
		logger=report.createTest("Login Test");
		
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		
		login.loginToApplication(new ExcelReader().getCellData("Login",0,0), new ExcelReader().getCellData("Login",0,1));
		
		logger.info("User is able to login");
		
	}
	
	@Test(priority=1)
	public void createUser()
	{
		logger=report.createTest("Create User Test");
		User user=PageFactory.initElements(driver, User.class);
		user.createUser();
		logger.info("User is able to create user");
	}
	
	
	@Test(priority=2,dependsOnMethods="loginAsAdmin")
	public void logoutFromApplication()
	{
		logger=report.createTest("Create User");
	
		LogoutPage logout=PageFactory.initElements(driver, LogoutPage.class);
		
		logout.logoutFromApplication();
		
		logger.info("User is able to logoff");
	}
	
	
	


}
