package com.PageFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.reports.ExtentManager;

public class PwChangeNewUser extends ExtentManager {
	WebDriver driver;
	
	public PwChangeNewUser(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="oldPassword")
	WebElement oldPassword;
	
	@FindBy(id="newPassword")
	WebElement newPassword;
	
	@FindBy(id="verifyNewPassword")
	WebElement retypePassword;
	
	@FindBy(id="submitButton")
	WebElement submit;
	
	public void changePassword() {
		oldPassword.sendKeys(TestBase.config.getProperty("generalPassword"));
		newPassword.sendKeys(TestBase.config.getProperty("newPassword"));
		retypePassword.sendKeys(TestBase.config.getProperty("newPassword"));
		submit.click();
	}
	
	
	
	

}
