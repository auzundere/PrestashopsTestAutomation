package com.amazonaws.tests;

import static org.testng.Assert.*;

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
	  assertTrue(calculator.description.getAttribute("value").isEmpty());
	  assertEquals(calculator.getInstanceCount(),1);
  }
  
  
}
