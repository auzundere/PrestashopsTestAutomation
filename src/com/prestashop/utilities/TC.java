package com.prestashop.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TC {
	public static WebDriver driver;
	public static void browsersSelection(String name) {
		if(name.equalsIgnoreCase("chrome")) {
			System.setProperty(Configuration.getProperty("chromedriver"), Configuration.getProperty("chromepath"));
			//Open browser
			driver = new ChromeDriver();
			//make the find element keep trying
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.switchTo().window(driver.getWindowHandle());
		}
		if(name.equalsIgnoreCase("firefox")) {
			System.setProperty(Configuration.getProperty("firefoxdriver"), Configuration.getProperty("firefoxpath"));
			//Open browser
			driver = new FirefoxDriver();
			//make the find element keep trying
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().setPosition(new Point(-1500, 0));
			//driver.switchTo().window(driver.getWindowHandle());
		}
		if(name.equalsIgnoreCase("safari")) {
			System.setProperty("webdriver.safari.noinstall", "true"); //To stop uninstall each time
			driver = new SafariDriver();
		}
	}
	
	
}
