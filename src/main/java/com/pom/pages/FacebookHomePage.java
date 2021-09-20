package com.pom.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.pom.base.TestBase;

public class FacebookHomePage extends TestBase {
	
	By email = By.id("email");
	By password = By.id("pass");
	By signInButton = By.name("login");
	By errormsghomepage = By.xpath("//div[@class='_9ay7']");
	
	public void loginFB(String userid, String loginpassword) {
		driver.findElement(email).sendKeys(userid);
		driver.findElement(password).sendKeys(loginpassword);
		driver.findElement(signInButton).click();
	}
	
	public String getErrorMsgHomePage() {
		
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicittime")), TimeUnit.SECONDS);
		String message =  driver.findElement(errormsghomepage).getText();
		System.out.println(message);
		return message;
	}

}
