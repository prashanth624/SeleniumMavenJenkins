package com.pom.pages;

import org.openqa.selenium.By;

import com.pom.base.TestBase;

public class forgottenPasswordPage extends TestBase {
	
	
	By forgotpasswordlink = By.linkText("Forgotten password?");
	By mobileNumber = By.id("identify_email");
	By searchBtn = By.name("did_submit");
	
	public void forgotpwd(String phonenumber) {
		
		driver.findElement(forgotpasswordlink).click();
		driver.findElement(mobileNumber).sendKeys(phonenumber);
		driver.findElement(searchBtn).click();
	}

}
