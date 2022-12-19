package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.learnautomation.helper.Utility;

public class User {

	WebDriver driver;
	
	public User(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By adminText=By.xpath("//b[text()='Admin']");
	
	By addUserButton=By.id("btnAdd");
	
	public void createUser()
	{
		Utility.waitForWebElementAndClick(driver, adminText, "Click On  Admin Tab");
		
		Utility.waitForWebElementAndClick(driver, addUserButton, "Click on add user button");
	}
	
}
