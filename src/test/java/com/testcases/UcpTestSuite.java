package com.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.base.TestBase;
import com.utilities.JSWaiter;
import com.utilities.TestUtil;

import Dataproviders.TestNgDataProviders;

import com.PageFunctions.*;


public class UcpTestSuite extends TestBase {
	public ucpLoginPage _loginPage;
	public ucpHomePage  _homePage;
	public ucpSkipDetails _skipPage;
	@BeforeMethod
	public void initialisation() {
		_loginPage= new ucpLoginPage(driver);
		_homePage = new ucpHomePage(driver);
		_skipPage = new ucpSkipDetails(driver);
		
	}
	
	
	@Test
	public void CreateNewUser() throws InterruptedException, FileNotFoundException, IOException {
		_loginPage.loginToUcp(config.getProperty("testsiteurl"),config.getProperty("UcpAdminUserName"), config.getProperty("UcpAdminPassword"));
		_skipPage.skipDetails();
		_homePage.navigateToAdminPage();
		 TestUtil.switchWindow("Admin");
		_adminPage.clickonUsers();
		_adminPage.clickOnAddUser();
		_addUserDetails.addDetails("UCPAdminUser");
		_addUserDetails.assignRoleButton();
		_assignRole.searchAndSelectRole(config.getProperty("Adminrole"));		
		_addUserDetails.assignStoreButton();
		_assignStore.assignStore();
		_addUserDetails.save();
		_adminPage.logOut();
		//driver.close();
	}
	
	@Test(dependsOnMethods={"CreateNewUser"})
	public void Firsttimeuserlogin() throws InterruptedException, FileNotFoundException, IOException {
		
		_loginPage.loginToUcp(config.getProperty("testsiteurl"),TestUtil.getProperty("testData","createdSimpleId"), config.getProperty("generalPassword"));// testData.getProperty("changedPassword"));//  ;
		_newUserPwChange.changePassword();
		_skipPage.skipDetails();
		Thread.sleep(1000);
		_ucpSecurityQuestions.HandlesecurityquestionPage(TestUtil.getProperty("testData","securityquestion"),TestUtil.getProperty("testData","securityanswer"),TestUtil.getProperty("testData","changedPassword"));
		_ucpSecurityQuestions.UpdateNewUserdetails(TestUtil.getProperty("testData","createdSimpleId"), TestUtil.getProperty("testData","Update_User_phoneNumber"));
		//driver.close();
	}
	
	
	@Test(dependsOnMethods={"Firsttimeuserlogin"})
	public void UserSearch() throws FileNotFoundException, IOException{
	_loginPage.loginToUcp(config.getProperty("testsiteurl"),TestUtil.getProperty("testData","createdSimpleId"), TestUtil.getProperty("testData","changedPassword"));
	_skipPage.skipDetails();
	_AssignApplicationAccess.Usersearch(TestUtil.getProperty("testData","createdSimpleId"));
	}
	
	@Test(dependsOnMethods={"UserSearch"},dataProvider ="UCPApplications" ,dataProviderClass =TestNgDataProviders.class)
	  public void ApplicationAccess(String Application,String ApplicationValue1) throws Exception{
		_UCPApplicationsAccess.assignApplicationstouser(ApplicationValue1);
	}
	
	/*@Test(dependsOnMethods={"ApplicationAccess"},priority=4,dataProvider ="DASHBOARDAPPS" ,dataProviderClass =TestNgDataProviders.class)
	 public void DashboardAccessValidation(String Application,String AppNameOnDashboard) throws Exception{
		_UCPApplicationsAccess.assignApplicationstouser(AppNameOnDashboard);
		}*/
		
	@Test(enabled = false)
	public void CreatNonAdminUser() throws InterruptedException, FileNotFoundException, IOException {
		_loginPage.loginToUcp(config.getProperty("testsiteurl"),config.getProperty("UcpAdminUserName"), config.getProperty("UcpAdminPassword"));
		_skipPage.skipDetails();
		_homePage.navigateToAdminPage();
		 TestUtil.switchWindow("Admin");
		//driver.close();
	}
	@Test
	public void DeleteUser() throws InterruptedException {
		_loginPage.loginToUcp(config.getProperty("testsiteurl"),config.getProperty("UcpAdminUserName"), config.getProperty("UcpAdminPassword"));
		_skipPage.skipDetails();
		_homePage.navigateToAdminPage();
		TestUtil.switchWindow("Admin");
		for (int i =0; i<20; i++) {
		_adminPage.clickonUsers();
		_adminPage.searchUser();		
		_adminPage.viewUser();
		_userDetails.clickOnDelete();
		_userDetails.confirmDelete();
		}
	}
}

