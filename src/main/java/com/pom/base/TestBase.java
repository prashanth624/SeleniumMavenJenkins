/*
 * Author: Prashanth Aitha
 * Date: 20 Sep 2021
 */

package com.pom.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileInputStream fis;
	
	
	public Properties getProperties() throws Exception {
		
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
		prop.load(fis);
		return prop;
		
	} 
	
	
	public void setUp() throws Exception {
		getProperties();
		
		/*fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
		prop.load(fis);*/
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.get(prop.getProperty("applicationurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicittime")), TimeUnit.SECONDS);
		
	}
	
	public void tearDown() {
		driver.close();
	}

}
