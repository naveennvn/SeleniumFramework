package Dataproviders;

import org.testng.annotations.DataProvider;

public class TestNgDataProviders {
	
	 @DataProvider(name = "UCPApplications")

	  public static Object[][] Applications() {

	        return new Object[][] {
	           	{ "ApplicationName", "eSupportDlrAdmin" },
	        	{ "ApplicationName", "eStore3PADlrUser" },
	        	{ "ApplicationName", "eStore3PAVendorUser" },
	        	{ "ApplicationName", "LenderFormUser" },
	        	{ "ApplicationName", "LenderFormDlrAdmin" },
	        	{ "ApplicationName", "LenderFormDlrUser" },
	        	{ "ApplicationName", "LenderFormVendorAdmin" },
	        	{ "ApplicationName", "LenderFormVendorUser" },
	        	{ "ApplicationName", "LenderForm Internal User" },
	        	{ "ApplicationName", "AUA General Profile Dealer Admin" }
	        	};
	  }
	 
	 @DataProvider(name = "DASHBOARDAPPS")

	 public static Object[][] ApplicationsOnDashboard() {

	        return new Object[][] {
	           	{ "ApplicationName", "eSupportDlrAdmin" },
	        	{ "ApplicationName", "eStore3PADlrUser" },
	        	};
	  }
	 

}