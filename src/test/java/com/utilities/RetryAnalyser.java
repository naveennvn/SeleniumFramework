package com.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {
	int count  = 0;
	int maxTry = 2;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub

        if (!result.isSuccess()) {                            //Check if test not succeed
            if (count < maxTry) {                             //Check if maxtry count is reached
                count++;                                      //Increase the maxTry count by 1
                System.out.println("is this working?");              
                result.setStatus(ITestResult.FAILURE);        //Mark test as failed
                return true;                                 //Tells TestNG to re-run the test
            } else {
                result.setStatus(ITestResult.FAILURE);      //If maxCount reached,test marked as failed
            }
        }
         else {
           result.setStatus(ITestResult.SUCCESS);         //If test passes, TestNG marks it as passed
        }
        return false;
	}

}
