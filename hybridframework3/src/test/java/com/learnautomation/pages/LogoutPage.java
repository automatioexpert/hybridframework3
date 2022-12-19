package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.learnautomation.helper.Utility;

public class LogoutPage {

	WebDriver driver;

	public LogoutPage(WebDriver driver)
	{
		this.driver=driver;
	}

	By welcomeText=By.xpath("//a[contains(text(),'Welcome ')]");
	By logOutText=By.xpath("//a[contains(text(),'Logout')]");
	
	
	public void logoutFromApplication()
	{
		Utility.waitForWebElementAndClick(driver, welcomeText, "Click on Welcome");
		Utility.waitForWebElementAndClick(driver, logOutText, "Click on logout");
		Assert.assertTrue(Utility.waitForURL(driver, "login"));
	}
	
}
