package com.PageFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cutomFunctions.CustomLocatorbyxpath;
import com.reports.ExtentManager;

public class AssignApplicationAccess extends ExtentManager {
		WebDriver driver;
		WebElement Userelements;

		public AssignApplicationAccess(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

		@FindBy(xpath = "//span[text()='User Administration']")
		WebElement Home_USerAdmin;
		
		@FindBy(name = "loginId")
		WebElement _USeremailidtosearch;
		
		@FindBy(xpath = "//button[@type='submit']")
		WebElement Adminpage_SearchUser;
		
		@FindBy(xpath = "//div[@class='mdc-card']/nav/a[2]")
		WebElement admin_applicationacces_tab;
		

public void Usersearch(String SUsername){
	
	Home_USerAdmin.click();
	_USeremailidtosearch.clear();
	_USeremailidtosearch.sendKeys(SUsername);
	Adminpage_SearchUser.click();
	Userelements = driver.findElement(new CustomLocatorbyxpath(SUsername));
	Userelements.click();
	admin_applicationacces_tab.click();
	
	}

}
