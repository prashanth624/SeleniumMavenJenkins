package com.pom.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.pom.pages.FacebookHomePage;

public class TestFacebookLoginPage {
	
	FacebookHomePage fbhp = new FacebookHomePage();
	public static Logger log = LogManager.getLogger(TestFacebookLoginPage.class);
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeTest
	public void setExtent() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/myReport.html");
		extent = new ExtentReports();
		htmlReporter.config().setReportName("Functional Testing");
		htmlReporter.config().setTheme(Theme.DARK);
		//extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "TestEnv");
		extent.setSystemInfo("user", "Prashanth");
		
	}
	
	@AfterTest
	public void endReport() {
		extent.flush();
	}
	
	@AfterMethod
	public void amextentreport(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "TEST CASE FAILED IS "+result.getName());
			test.log(Status.FAIL, "TEST CASE FAILED IS "+result.getThrowable());
		} else if(result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "TEST CASE FAILED IS "+result.getName());
		} else if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "TEST CASE FAILED IS "+result.getName());
		}
	}
	
	
	
	@Test
	public void enterCredentials() {
		test = extent.createTest("Test Case 1");
		try {
			fbhp.setUp();
			log.info("browser is opened");
			log.info("enter the credentials");
			fbhp.loginFB("username1", "password1");
			log.info("login credentials entered successfully");

		} catch (Exception e) {
			System.out.println("failed with below error");
			System.out.println(e.getMessage());
			System.out.println("*******************************");
			e.printStackTrace();
			
		}
	}
	
	@Test
	public void getLoginError() {
		test = extent.createTest("Test Case 2");
		String expectedError = " The password that you've entered is incorrect. Forgotten password?";
		String actualError = fbhp.getErrorMsgHomePage();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualError, expectedError);
		sa.assertAll();
		
	}
	
	/*@Test
	public void closeBrowser() {
		fbhp.tearDown();
		log.info("browser is closed");
		fbhp.tearDown();
		log.info("browser is closed");
		Reporter.log("TestFacebookLoginPage TC passed");
		
	}*/
}
