package com.PageFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.reports.ExtentManager;
import com.utilities.TestUtil;

public class AssignRoleSubPage extends ExtentManager {
	WebDriver driver;
	
	public AssignRoleSubPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath="(//input[contains(@class,'searchField')])[3]")
	public WebElement searchField;
	
	@FindBy(xpath="(//button[contains(@class,'search-button')])[3]")
	public WebElement searchButton;
	
	@FindBy(xpath="//button[text()='Assign']")
	public WebElement assignRole;
	
	public WebElement searchtext(String RoleName) {
		 return driver.findElement(By.xpath("//span[text()='" + RoleName +"']//ancestor::*/td/div/input[@type='checkbox']"));
	}
	
	public void searchAndSelectRole(String role) throws InterruptedException {
		searchField.sendKeys(role);
		searchButton.click();
		Thread.sleep(2000);
		searchtext(role).click();
		assignRole.click();
		test.log(LogStatus.INFO, "Role assigned: " + role);
	}
	

}
