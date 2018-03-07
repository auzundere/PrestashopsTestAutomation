package com.prestashop.tests.registration;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.prestashop.pages.AccountPage;
import com.prestashop.pages.HomePage;
import com.prestashop.pages.LoginPage;
import com.prestashop.utilities.Configuration;
import com.prestashop.utilities.TestBaseClass;

public class LoginTests extends TestBaseClass {

	@Test(groups = "smoke")
	public void positiveLoginTest() {
		// create object from Page class:
		HomePage homePage = new HomePage(driver);
		// verify at page
		assertTrue(homePage.isAt());
		// verify logo is displayed
		assertTrue(homePage.logo.isDisplayed());

		homePage.gotoLoginPage();

		LoginPage loginPage = new LoginPage(driver);
		assertTrue(loginPage.isAt());

		assertTrue(loginPage.createAccountlabel.isDisplayed());
		assertTrue(loginPage.alreadyRegisteredLabel.isDisplayed());

		// Enter valid email and password then click sign in
		/*
		 * loginPage.email.sendKeys(Configuration.getProperty("email"));
		 * loginPage.password.sendKeys(Configuration.getProperty("password"));
		 * loginPage.SubmitLogin.click();
		 */
		loginPage.login(Configuration.getProperty("email"), Configuration.getProperty("password"));

		AccountPage accountPage = new AccountPage(driver);
		assertTrue(accountPage.isAt(), "Account page is not loaded/displayed");

		assertTrue(accountPage.verifyUserOptions("ORDER HISTORY AND DETAILS", "MY CREDIT SLIPS", "MY ADDRESSES",
				"MY PERSONAL INFORMATION", "MY WISHLISTS"));

	}
}
