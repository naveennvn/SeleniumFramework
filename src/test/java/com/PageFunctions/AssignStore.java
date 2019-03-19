package com.PageFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.reports.ExtentManager;
import com.utilities.JSWaiter;
import com.utilities.TestUtil;

public class AssignStore extends ExtentManager {
	WebDriver driver;
	public AssignStore(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//span[contains(text(),'Store Id')]/ancestor::*/th/input[@type='checkbox'])[2]")
	public WebElement selectStore;
	
	@FindBy(xpath="//button[text()='Assign']")
	public WebElement assignStore;

	public void assignStore() {
		selectStore.click();
		assignStore.click();
		test.log(LogStatus.INFO, "All Stores assigned using method: ");
	}
}
