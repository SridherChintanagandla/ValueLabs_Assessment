package com.pages.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	WebDriver driver;
	public Home_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement txt_Search;
	
	@FindBy(id="nav-search-submit-button")
	private WebElement btn_Submit;
	
	@FindBy(id="nav-cart-count-container")
	private WebElement ele_cart;
	
	@FindBy(xpath="//div[@data-component-type='s-search-result'][1]")
	private WebElement  ele_firstProduct;
	
	@FindBy(xpath="//div[@data-component-type='s-search-result'][2]")
	private WebElement  ele_secondProduct;
	
	@FindBy(xpath="//div[@data-component-type='s-search-result'][1]//span[@class='a-price-whole']")
	private WebElement  txt_firstProductPrice;
	
	@FindBy(xpath="//div[@data-component-type='s-search-result'][2]//span[@class='a-price-whole']")
	private WebElement  txt_secondProductPrice;
	
	
	
	public void searchProduct(String text) {
		txt_Search.sendKeys(text);
		btn_Submit.click();
	}
	
	public String fetchFirstProductPrice() {
		return txt_firstProductPrice.getText().trim();
	}
	
	public String fetchSecondProductPrice() {
		return txt_secondProductPrice.getText().trim();
	}
	
	public void view1stProduct() {
		ele_firstProduct.click();
	}
	
	public void view2ndProduct() {
		ele_secondProduct.click();
	}
	
	public void viewCart() {
		ele_cart.click();
	}
}
