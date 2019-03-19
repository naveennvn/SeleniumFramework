package com.PageFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.reports.ExtentManager;
	
	public class UserAdminValidations extends ExtentManager {
		WebDriver driver;

		public UserAdminValidations(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

		@FindBy(xpath = "//span[text()='User Administration']")
		WebElement UCPHome_USerAdmin;
		
		
}