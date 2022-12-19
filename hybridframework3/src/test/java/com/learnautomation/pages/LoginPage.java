package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.learnautomation.helper.Utility;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}

	By username=By.id("txtUsername");
	By password=By.id("txtPassword");
	By loginButton=By.id("btnLogin");

	
	public void loginToApplication(String uname,String pass)
	{
		Utility.waitForWebElementAndType(driver, username, uname, "Enter username");
		Utility.waitForWebElementAndType(driver, password, pass, "Enter password");
		Utility.waitForWebElementAndClick(driver, loginButton, "Click On Login button");
		Assert.assertTrue(Utility.waitForURL(driver, "dashboard"));
	}
	
	
}
