package com.PageFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.reports.ExtentManager;
import com.utilities.JSWaiter;
import com.utilities.TestUtil;

public class ucpHomePage extends ExtentManager {
	WebDriver driver;
	
	public ucpHomePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//i[@class='cdkicon-apps cdk-gh-app-switcher__launcher-icon']")
	public WebElement useradmin;
	
	@FindBy(xpath="//span[text()='Admin']/parent::a")
	 public WebElement adminbutton;
	
	
	
	public void navigateToAdminPage() {
		JSWaiter.waitAllRequest();
		useradmin.click();
		JSWaiter.waitAllRequest();
		adminbutton.click();
		test.log(LogStatus.INFO, "Navigated to Admin Page");		
	}
	

}
