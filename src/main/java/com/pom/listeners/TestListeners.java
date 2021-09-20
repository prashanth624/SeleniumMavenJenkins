package com.pom.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.pom.utilities.TestUtility;

public class TestListeners implements ITestListener {
	
	
	public void onTestStart(ITestResult result) {
		Reporter.log("TestNG method started "+result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("TestNG method Passed "+result.getName());
		System.out.println("TestNG method Passed "+result.getName());
		Reporter.log("<br>");  // next line
	}

	public void onTestFailure(ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("TestNG method failed "+result.getName());
		Reporter.log("click to see screenshot");
		Reporter.log("<br>");  // next line
		
		TestUtility.takeScreenshot("C:\\EclipseWorkspace\\MavenFramework\\src\\test\\resources\\Screenshots\\errormessage1.png");
		Reporter.log("<a target=\"_blank\" href=\"C:\\EclipseWorkspace\\MavenFramework\\src\\test\\resources\\Screenshots\\errormessage1.png\">Screenshot</a>");
		
		//String screenshotpath = "C:\\EclipseWorkspace\\MavenFramework\\src\\test\\resources\\Screenshots\\"+result.getName()+".png";
		//TestUtility.takeScreenshot(screenshotpath);
		//Reporter.log("<a target=\"_blank\" href=\""+screenshotpath+">Screenshot</a>");
	}

	public void onTestSkipped(ITestResult result) {
		Reporter.log("TestNG method skipped "+result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onStart(ITestContext context) {
		Reporter.log("TestNG method started "+context.getName());
		
	}

	
	public void onFinish(ITestContext context) {
		Reporter.log("TestNG method finished "+context.getName());
		
	}

}
