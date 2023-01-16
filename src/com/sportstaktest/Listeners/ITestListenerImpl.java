package com.sportstaktest.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerImpl extends ExtentReportListener implements ITestListener  {
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		
		System.out.println("PASS");
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("FAIL");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("SKIP");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		System.out.println("Execution started on Local env...");
		extent= setUp();
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("Execution completed on Local env...");
		extent.flush();		
		System.out.println("Generated Report. . .");	
		
	}
	

}
