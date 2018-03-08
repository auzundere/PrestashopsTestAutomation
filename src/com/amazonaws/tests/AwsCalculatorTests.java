package com.amazonaws.tests;

import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.amazonaws.pages.AwsCalculatorPage;
import com.prestashop.utilities.TestBaseClass;

public class AwsCalculatorTests extends TestBaseClass{
	 
	AwsCalculatorPage calculator = new AwsCalculatorPage();
	 
  @Test(priority = 0, description="Monthly Bill should be $0.00 by default")
  public void defaultMonthlyBillTest() {
	assertTrue(calculator.isAt());
	assertEquals(calculator.getMonthlyBillAmount(),0.00);
  }
  
  @Test(priority = 1)
  public void addingMachineTests() {
	  calculator.addEc2.click();
	  //verify description inout box is empty
	  assertTrue(calculator.description.getAttribute("value").isEmpty());
	  //verify Instance Count is 1
	  assertEquals(calculator.getInstanceCount(calculator.instanceCount.getAttribute("value")),1);
	  //verify Usage Percentage is 100
	  assertEquals(calculator.getInstanceCount(calculator.usagePercent.getAttribute("value")),100);
	  //verify Usage Type is % Utilized/Month
	  assertEquals(calculator.getUsageOption(),"% Utilized/Month");
	  //verfy type is Linux on t1.micro
	  assertEquals(calculator.ec2type.getText(),"Linux on t1.micro");
	  //verify billing Option is  On-Demand (No Contract)
	  assertEquals(calculator.billingOption.getText(),"On-Demand (No Contract)");
	  //verify the product price is 14.64
	  double expectedDynamicPrice = calculator.getMonthlyCost();
	  assertEquals(expectedDynamicPrice,14.64);
	  //verify the product price is on the main page is the same with the product price on the monthly bill page
	  Actions actions = new Actions(driver);
	  actions.moveToElement(calculator.billLabel).click().perform();
	  double productPrice = Double.parseDouble(calculator.monthlyBillCostBeforeDiscount.getAttribute("value"));
	  assertEquals(productPrice,expectedDynamicPrice);
	  //go back to services tab
	  calculator.services.click();
  }
  
  @Test(priority = 2)
  public void clearFormTests() {
	  //click clear form button
	  calculator.clearButton.click();
	  //assert confirm Dialog is displayed
	  assertTrue(calculator.confirmDialog());
	  //assert confirmation messages has displayed
	  String popupText = calculator.confirmDialog.getText();
	  assertTrue(popupText.contains("Please Confirm")
			  && popupText.contains("Are you sure you want to clear all entries in this service form?")
			  );
	  //click OK button
	  calculator.OK.click();
	  //verify form is cleared
	  assertTrue(calculator.isEC2InstancesTableClear());
  }
  
  
}
