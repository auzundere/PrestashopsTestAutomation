package com.prestashop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//ADD EMAIL, PASSWORD, SIGNIN BUTTONS TO loginPage CLASS

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	public WebElement email;
	
	@FindBy(id="passwd")
	public WebElement password;
	//It will search the element by ID=SubmitLogin or name=SubmitLogin
	public WebElement SubmitLogin;
	
	@FindBy(xpath="//h3[.='Create an account']")
	public WebElement createAccountlabel;
	
	@FindBy(xpath="//h3[.='Already registered?']")
	public WebElement alreadyRegisteredLabel;
	
	public boolean isAt() {
		return driver.getTitle().equals("Login - My Store");
	}
	
	public void login(String lEmail, String lPassword) {
		email.sendKeys(lEmail);
		password.sendKeys(lPassword);
		SubmitLogin.click();
	}

}
