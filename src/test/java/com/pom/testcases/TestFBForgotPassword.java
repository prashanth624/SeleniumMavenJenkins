package com.pom.testcases;

import org.testng.annotations.Test;

import com.pom.pages.forgottenPasswordPage;

public class TestFBForgotPassword {
	
	forgottenPasswordPage fpp = new forgottenPasswordPage();
	
	@Test
	public void testForgotPassword() {
		
		try {
			fpp.setUp();
			fpp.forgotpwd("6747898757645");
			fpp.tearDown();
			
		} catch (Exception e) {
			System.out.println("failed with below error");
			System.out.println(e.getMessage());
			System.out.println("*******************************");
			e.printStackTrace();
		}
	}
  
}
