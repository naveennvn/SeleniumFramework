package com.PageFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;
import com.reports.ExtentManager;
import com.utilities.JSWaiter;

public class ucpSecurityQuestions extends ExtentManager {
	WebDriver driver;

	public ucpSecurityQuestions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select")
	WebElement SecurityQuestionDropDown;

	@FindBy(xpath = "//input[@name='answer']")
	WebElement SecurtyAnswer;

	@FindBy(xpath = "//input[@name='password']")
	WebElement Securtypassword;

	@FindBy(xpath = "//button[@id='submitButton']")
	WebElement Submituserdetials_button;

	@FindBy(xpath = "//input[@type='email']")
	WebElement Updateuseremailid;

	@FindBy(xpath = "//input[@type='phone']")
	WebElement Updateuserphone;
	

	@FindBy(xpath = "//button[@type='submit']")
	WebElement Updatesuserdetials_button;

	

	public void HandlesecurityquestionPage(String Squestion, String Sanswer, String Spassword)
			throws InterruptedException {

		Select SecurityDdown = new Select(SecurityQuestionDropDown);
		SecurityDdown.selectByIndex(1);

		test.log(LogStatus.INFO, "Security question selected");
		SecurtyAnswer.sendKeys(Sanswer);
		Securtypassword.sendKeys(Spassword);
		Submituserdetials_button.click();
		
		
		/*Actions act= new Actions(driver);
		act.moveToElement(Submituserdetials_button).doubleClick().build().perform();
*/

		/*if (Security_Submitbutton.isEnabled()) {
			Security_Submitbutton.click();
		} else {
			Thread.sleep(100);
			Security_Submitbutton.click();
		}*/

		test.log(LogStatus.INFO, "Handled security Questions");
	}

	public void UpdateNewUserdetails(String useremailid, String Userphonenenumber) {

		Updateuseremailid.sendKeys(useremailid);
		Updateuserphone.sendKeys(Userphonenenumber);
		Updatesuserdetials_button.click();

	}

}