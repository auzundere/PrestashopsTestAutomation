package com.prestashop.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBaseClass{
	protected static WebDriver driver;
	@BeforeClass(alwaysRun=true)
	@Parameters("browser")
	public void setUp(@Optional String browser) {
		driver=Driver.getDriver(browser);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(Configuration.getProperty("awc_calculator_url"));
	}

	@AfterClass(alwaysRun=true)
	public void tearDown() {
		//driver.quit();
		Driver.quit();
	}	
	public static String getOnlyDigits(String str) {
		String result ="";
		for(int i=0;i<str.length();i++) {
			if(Character.isDigit(str.charAt(i))) {
				result+=str.charAt(i)+"";
			}
		}
		
		return result;
	}
	public static double convertToDoubleBackToString(String price) {
		price = price.replace("$", "");
		return Double.parseDouble(price);
	}
	
}
