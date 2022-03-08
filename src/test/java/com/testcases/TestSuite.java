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


public class TestSuite extends TestBase {
	
	public AdminPage _adminPage;
	public AddUserPage _addUserDetails;
	public AssignRoleSubPage _assignRole;
	public AssignStore _assignStore;
	public TestUtil _TestUtil;
	public UserDetails _userDetails;
	@BeforeMethod
	public void initialisation() {
		_adminPage = new AdminPage(driver);
		_addUserDetails = new AddUserPage(driver);
		_assignStore = new AssignStore(driver);
		_assignRole=new AssignRoleSubPage(driver);
		_userDetails = new UserDetails(driver);
		
	}
	
	
	@Test
	public void CreateNewUser() throws InterruptedException, FileNotFoundException, IOException {
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
	
	
	@Test(dependsOnMethods={"UserSearch"},dataProvider ="UCPApplications" ,dataProviderClass =TestNgDataProviders.class)
	  public void ApplicationAccess(String Application,String ApplicationValue1) throws Exception{
	
	}
	
		
	@Test(enabled = false)
	public void CreatNonAdminUser() throws InterruptedException, FileNotFoundException, IOException {
		 TestUtil.switchWindow("Admin");
		_adminPage.clickonUsers();
		_adminPage.clickOnAddUser();
		_addUserDetails.addDetails("UCPUSER");
		_addUserDetails.assignRoleButton();
		_assignRole.searchAndSelectRole(config.getProperty("Userrole"));		
		_addUserDetails.assignStoreButton();
		_assignStore.assignStore();
		_addUserDetails.save();
		_adminPage.logOut();
		//driver.close();
	}
	
}

