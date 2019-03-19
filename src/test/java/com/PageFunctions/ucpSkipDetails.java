package com.PageFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.reports.ExtentManager;

public class ucpSkipDetails extends ExtentManager {
	WebDriver driver;
	
	public ucpSkipDetails(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//button[contains(text(),'Skip for now')]")
	public WebElement skip;
	
	public void skipDetails() {
		skip.click();
	}

}
