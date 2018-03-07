package com.amazonaws.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.prestashop.utilities.Driver;

public class AwsCalculatorPage {
	private WebDriver driver;
	public AwsCalculatorPage() {
		this.driver = Driver.getDriver(null);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="billLabel")
	public WebElement billLabel;

	@FindBy(xpath="//tr[@class='EC2InstanceRow itemsTableDataRow table']//input[@class='gwt-TextBox input']")
	public WebElement description;
	
	@FindBy(xpath="//table[@class='SF_EC2_INSTANCE_FIELD_INSTANCES field integerNumericField']//input[@class='gwt-TextBox numericTextBox input']")
	public WebElement instanceCount;
	
	public int getInstanceCount() {
		return Integer.parseInt(instanceCount.getAttribute("value"));
	}

	@FindBy(xpath="(//*[@class='gwt-TextBox numericTextBox input'])[2]")
	public WebElement usage;
	
	//(//select[@class='gwt-ListBox unit'])[1]

	@FindBy(xpath="(//*[@class='gwt-PushButton small gwt-PushButton-up'])[1]//img")
	public WebElement addEc2;
	

	public boolean isAt() {
		return driver.getTitle().equals("Amazon Web Services Simple Monthly Calculator");
	}
	
	public double getMonthlyBillAmount() {
		return Double.parseDouble((billLabel.getText().split("\\$ ")[1].replace(")", "")));
	}
	
	
	
}
