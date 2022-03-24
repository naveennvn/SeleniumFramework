
package com.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pagefunctions.AddUserPage;
import com.pagefunctions.AdminPage;
import com.pagefunctions.AssignRoleSubPage;
import com.pagefunctions.AssignStore;
import com.pagefunctions.UserDetails;
import com.utilities.TestUtil;


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
		_adminPage.clickonUsers();
		_adminPage.clickOnAddUser();
		_addUserDetails.addDetails("AdminUser");
		_addUserDetails.assignRoleButton();
		_assignRole.searchAndSelectRole(config.getProperty("Adminrole"));		
		_addUserDetails.assignStoreButton();
		_assignStore.assignStore();
		_addUserDetails.save();
		_adminPage.logOut();
		//driver.close();
	}
	
	
		
	@Test(enabled = false)
	public void CreatNonAdminUser() throws InterruptedException, FileNotFoundException, IOException {
		_adminPage.clickonUsers();
		_adminPage.clickOnAddUser();
		_addUserDetails.addDetails("USEROne");
		_addUserDetails.assignRoleButton();
		_assignRole.searchAndSelectRole(config.getProperty("Userrole"));		
		_addUserDetails.assignStoreButton();
		_assignStore.assignStore();
		_addUserDetails.save();
		_adminPage.logOut();
		//driver.close();
	}
	
}

