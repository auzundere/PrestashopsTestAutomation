package com.prestashop.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

/*
 * WebDriver factory
 * takes string as input and returns the implementation of the webdriver based on that
 */
public class Driver {

	private static WebDriver driver;

	public static WebDriver getDriver(String browser) {
		
		String driverType = browser==null? Configuration.getProperty("browser") : browser;
		
		// if browser has value, use browser
		// else use the value from the configuration file
		
		if (driver == null) {
			// create webdriver based on the value of browser parameter
			switch (driverType.toLowerCase()) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver",
						Configuration.getProperty("chromedriver"));
				driver = new ChromeDriver();
				break;
			case "firefox":
				System.setProperty("webdriver.gecko.driver", 
						Configuration.getProperty("geckodriver"));
				driver = new FirefoxDriver();
				break;
			case "opera":
				System.setProperty("webdriver.opera.driver", 
						Configuration.getProperty("operadriver"));
				driver = new OperaDriver();
				break;
			case "safari":
				driver = new SafariDriver();
				break;
			case "edge":
				
				break;
			}
		}
		// return
		return driver;
	}
	
	public static void quit() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
