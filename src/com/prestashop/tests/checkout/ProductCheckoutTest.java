package com.prestashop.tests.checkout;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.ProductPage;
import com.prestashop.utilities.TestBaseClass;

public class ProductCheckoutTest extends TestBaseClass {
	String productName = "Printed Summer Dress";

	/*
	 * open the prestashop click on product Printed Summer Dress on the home page
	 * verify the product name is Printed Summer Dress
	 */

	@Test(priority = 10)
	public void productListing() {
		HomePage homePage = new HomePage(driver);
		homePage.listing(productName).click();
		ProductPage productPage = new ProductPage(driver);
		assertEquals(productPage.name.getText(), productName);

	}

	/*
	 * open the product details page, add a product to the cart verify that
	 * confirmation message is displayed
	 */

	@Test(priority = 1, dependsOnMethods = "productListing")
	public void checkoutTest() {
		ProductPage productPage = new ProductPage(driver);
		productPage.addToCart.click();
		// explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOf(productPage.confirmation));

		assertTrue(productPage.confirmation.isDisplayed(), " Confirmation message was not displayed");
		String confirmation = "Product successfully added to your shopping cart";
		assertEquals(productPage.confirmation.getText().trim(), confirmation);

	}

}
