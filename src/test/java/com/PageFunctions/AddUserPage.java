package com.pagefunctions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;
import com.reports.ExtentManager;
import com.utilities.TestUtil;

public class AddUserPage extends ExtentManager {
	WebDriver driver;
	public AddUserPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="firstName")
	WebElement firstName;
	
	@FindBy(name="lastName")
	WebElement lastName;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement saveBtn;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="retypePassword")
	WebElement reTypePassword;
	
	@FindBy(xpath="//a[text()='Assign New Role']")
	WebElement assignNewRoleButton;
	
	@FindBy(xpath="//a[text()='Assign New Store']")
	WebElement assignStoreButton;

	
	
	public void addDetails(String usertype) throws FileNotFoundException, IOException {
		StringBuilder random = new StringBuilder();
		random = TestUtil.getRandomNum();
		String firstname = usertype+"-"+TestBase.config.getProperty("firstName") + random;
		String simpleid = random + TestBase.config.getProperty("SimpleId");
		TestUtil.writeProperty("testData", "createdUserName", firstname);
		TestUtil.writeProperty("testData", "createdSimpleId", simpleid);
		firstName.sendKeys(firstname);
		lastName.sendKeys(TestBase.config.getProperty("lastName"));
		password.sendKeys(TestBase.config.getProperty("generalPassword"));
		reTypePassword.sendKeys(TestBase.config.getProperty("generalPassword"));
		test.log(LogStatus.INFO, "Added new user details");
		
	}
	public void assignRoleButton() {
		assignNewRoleButton.click();
	}
	public void assignStoreButton() {
		assignStoreButton.click();
	}
	
	public void save() throws InterruptedException {
		
		//Actions a = new Actions(driver);
		//Thread.sleep(2000);
		//a.moveToElement(saveBtn).build().perform();
		//Thread.sleep(3000);
		//WebElement element = saveBtn; 
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-1000);");
		saveBtn.click();
		test.log(LogStatus.INFO, "User details Saved");
	}

}
