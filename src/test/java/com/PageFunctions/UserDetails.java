package com.pagefunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.reports.ExtentManager;

public class UserDetails extends ExtentManager {
 WebDriver driver;
	 
	 public UserDetails(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(xpath="//a[text()='Delete']")
	 WebElement Delete_link;
	 
	 @FindBy(xpath="//button[text()='Delete']")
	 WebElement Del_btn;
	 
	 public void clickOnDelete() {
		 Delete_link.click();
	 }
	 
	 public void confirmDelete() {
		 Del_btn.click();
	 }
}
