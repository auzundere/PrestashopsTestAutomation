package com.amazonaws.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
	
	@FindBy(xpath="//table[@class='SF_EC2_INSTANCE_FIELD_USAGE field usageField']//input")
	public WebElement usagePercent;
	
	@FindBy(xpath="//table[@class='SF_EC2_INSTANCE_FIELD_USAGE field usageField']//select")
	public WebElement usageType;

	@FindBy(xpath="//div[@class='gwt-HTML field SF_EC2_INSTANCE_FIELD_TYPE instanceTypeField rowDialogSelectorFieldView']")
	public WebElement ec2type;
	
	@FindBy(xpath="//div[@class='gwt-HTML field SF_COMMON_FIELD_BILLING instanceBillingField rowDialogSelectorFieldView']")
	public WebElement billingOption;

	@FindBy(xpath="//div[@class='gwt-HTML DynamicPrice DynamicPricePricing']")
	public WebElement monthlyCost;

	@FindBy(xpath="//a[.='Amazon EC2 Service (US-East)']/../../../td[4]/table/tbody/tr/td/input")
	public WebElement monthlyBillCostBeforeDiscount;
	
	@FindBy(xpath="//div[@class='restLabel']")
	public WebElement services;
	
	
	@FindBy(xpath="//button[@class='gwt-Button reset small']")
	public WebElement clearButton;
	
	@FindBy(xpath="//div[@class='gwt-DialogBox ConfirmDialog Dialog']")
	public WebElement confirmDialog;
	
	@FindBy(xpath="//button[.='Cancel']")
	public WebElement buttonCancel;
	
	@FindBy(xpath="//button[.='OK']")
	public WebElement OK;
	
	@FindBy(xpath="(//*[@class='gwt-PushButton small gwt-PushButton-up'])[1]//img")
	public WebElement addEc2;
	
	public boolean isEC2InstancesTableClear() {
		return driver.findElements(By.xpath("//tr[@class='EC2InstanceRow itemsTableDataRow table']")).isEmpty();
		
	}
	public boolean isAt() {
		return driver.getTitle().equals("Amazon Web Services Simple Monthly Calculator");
	}
	
	public double getMonthlyBillAmount() {
		return Double.parseDouble((billLabel.getText().split("\\$ ")[1].replace(")", "")));
	}
	
	public boolean confirmDialog() {
		return confirmDialog.isDisplayed();
	}
	public double getMonthlyCost() {
		return Double.parseDouble(monthlyCost.getText().replace("$", ""));
	}
	
	public String getUsageOption() {
		Select select = new Select(usageType);
		return select.getFirstSelectedOption().getText();
	}
	public int getInstanceCount(String str) {
		return Integer.parseInt(str);
	}
	
	
	
}
