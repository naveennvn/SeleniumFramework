package com.PageFunctions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.reports.ExtentManager;
import com.utilities.JSWaiter;


public class AdminPage extends ExtentManager {
	WebDriver driver;

	public AdminPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Users']/parent::a")
	WebElement usersTab;
	
	 @FindBy(xpath="//a[text()='Add User']")
	WebElement adduser; 
	 
	 
	 @FindBy(xpath="//div/i[@class='_circle']")
		WebElement UserProfileIcon;
	 
	 @FindBy(xpath="//span[text()='Sign Out']")
		WebElement SignOutLink;
	 
	 @FindBy(xpath="(//input[contains(@class,'searchField ')])[2]")
	 WebElement search_txt;
	 
	 @FindBy(xpath="(//tbody)[2]//a[text()='View']")
	 WebElement userView_btn;
	
	
	public void clickonUsers() {
		JSWaiter.waitAllRequest();
		usersTab.click();
		test.log(LogStatus.INFO, "Clicked on users tab in Admin Page");
	}
	
	public void clickOnAddUser() {
		JSWaiter.waitAllRequest();
		adduser.click();
		test.log(LogStatus.INFO, "Clicked on Add User in users tab on Admin Page");
	}
	
	public void logOut() throws InterruptedException {
		JSWaiter.waitAllRequest();
		
		Thread.sleep(1000);
		UserProfileIcon.click();
		SignOutLink.click();
		//code to be written for sign out button to be clicked
	}
	public void searchUser() {
		search_txt.sendKeys("ucptest");
		search_txt.sendKeys(Keys.ENTER);
	}
	public void viewUser() {
		JSWaiter.waitAllRequest();
		userView_btn.click();
	}
}
