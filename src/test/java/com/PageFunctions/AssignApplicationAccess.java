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
		WebElement UCPHome_USerAdmin;
		
		@FindBy(name = "loginId")
		WebElement UCP_USeremailidtosearch;
		
		@FindBy(xpath = "//button[@type='submit']")
		WebElement UCPAdminpage_SearchUser;
		
		@FindBy(xpath = "//div[@class='mdc-card']/nav/a[2]")
		WebElement ucpadmin_applicationacces_tab;
		

public void Usersearch(String SUsername){
	
	UCPHome_USerAdmin.click();
	UCP_USeremailidtosearch.clear();
	UCP_USeremailidtosearch.sendKeys(SUsername);
	UCPAdminpage_SearchUser.click();
	Userelements = driver.findElement(new CustomLocatorbyxpath(SUsername));
	Userelements.click();
	ucpadmin_applicationacces_tab.click();
	
	}

}
