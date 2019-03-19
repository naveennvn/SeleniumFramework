package com.PageFunctions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.cutomFunctions.ApplicationaccessCutomLocator;
import com.relevantcodes.extentreports.LogStatus;
import com.reports.ExtentManager;
import com.utilities.TestUtil;

public class UCPApplicationsAccess extends ExtentManager {
	WebDriver driver;
	WebElement Userelements;

	public UCPApplicationsAccess(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void assignApplicationstouser(String appname) throws Exception{

		Userelements = driver.findElement(new ApplicationaccessCutomLocator(appname));
		Userelements.click();
		Thread.sleep(5000);
		if(driver.getTitle().contains("CDK Global, LLC - DIT 2 - Sign In")|| driver.getTitle().contains("SSO Login")){
			test.log(LogStatus.FAIL, "Unable to give access to the application"+appname);
			driver.get(TestUtil.getProperty("Config", "testsiteurl"));
			String Username=TestUtil.getProperty("testData", "createdSimpleId");
			AssignApplicationAccess _AssignApplicationAccess=new AssignApplicationAccess(driver);
			_AssignApplicationAccess.Usersearch(Username);

		}
		else
		{
			test.log(LogStatus.PASS, "Granted access to the Application "+appname);
		}


	}
}
