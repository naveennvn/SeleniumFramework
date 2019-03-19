package com.reports;

import java.io.File;

import org.apache.log4j.Logger;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentManager {
	
	private static ExtentReports extent;
	public static ExtentTest test;
	public ExtentReports rep;
	
	public static ExtentReports getInstance(){
		
		if(extent==null){
			
			extent = new ExtentReports(System.getProperty("user.dir")+"//target//surefire-reports//html//extent.html",false,DisplayOrder.NEWEST_FIRST);
			extent.loadConfig(new File(System.getProperty("user.dir")+"//src//test//resources//extentconfig//ReportsConfig.xml"));
			
		}
		
		return extent;
		}
	
}
