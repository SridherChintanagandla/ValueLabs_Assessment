package com.pages.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Total_Summary_Page {
	WebDriver driver;
	public Total_Summary_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@data-item-index='2']//span[@class='currencyINR']//parent::span[1]")
	private WebElement txt_firstProductPrice;
	
	@FindBy(xpath="//div[@data-item-index='1']//span[@class='currencyINR']//parent::span[1]")
	private WebElement txt_secondProductPrice;
	
	public String fetchFirstProductPrice() {
		return txt_firstProductPrice.getText().trim();
	}
	
	public String fetchSecondProductPrice() {
		return txt_secondProductPrice.getText().trim();
	}
}
