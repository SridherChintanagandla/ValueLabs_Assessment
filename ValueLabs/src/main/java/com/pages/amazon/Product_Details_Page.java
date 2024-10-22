package com.pages.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_Details_Page {
	WebDriver driver;
	public Product_Details_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='centerCol']//span[@class='a-price-whole']")
	private WebElement txt_price;
	
	@FindBy(xpath="//input[@name='submit.add-to-cart']")
	private WebElement btn_addToCart;
	
	public String fetchProductPrice() {
		return txt_price.getText().trim();
	}
	
	public void clickAddToCart() {
		btn_addToCart.click();
	}
}
