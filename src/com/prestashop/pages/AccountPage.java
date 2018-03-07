package com.prestashop.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
	private WebDriver driver;
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".row.addresses-lists li")
	public List<WebElement> accountOptions;
	
	public boolean isAt() {
		return driver.getTitle().equals("My account - My Store");
	}
	
	public boolean verifyUserOptions(String... options) {
		if(accountOptions.isEmpty()) return false;
		
		List<String> expected = Arrays.asList(options);
		List<String> actual = new ArrayList<>();
		
		for(WebElement opt : accountOptions) {
			actual.add(opt.getText());
		}

		return actual.containsAll(expected);
		
	}
	
	
}
