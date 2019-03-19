package com.PageFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;
import com.reports.ExtentManager;

public class ucpLoginPage extends ExtentManager {
	WebDriver driver;
	
	public ucpLoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="proxyUsername")
	public  WebElement username;
	
	@FindBy(id="proxyPassword")
	public  WebElement password;
		
	@FindBy(id="loginSubmit")
	 public  WebElement submit;

	public void loginToUcp(String Url,String Username, String Password) {
		try {
			driver.get(Url);
			TestBase.log.debug("Navigated to : " + Url);
			driver.manage().window().maximize();
			username.clear();
			username.sendKeys(Username);
			password.clear();
			password.sendKeys(Password);
			submit.click();	
			test.log(LogStatus.PASS, "Logged into UCP successfully using: " + Username);
	}
		catch(Exception e) {
			e.printStackTrace();
			test.log(LogStatus.FAIL, "Unable to log into UCP using: " + Username);
		}		
	}
}
