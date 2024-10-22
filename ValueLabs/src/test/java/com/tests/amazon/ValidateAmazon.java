package com.tests.amazon;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.Base;
import com.pages.amazon.Home_Page;
import com.pages.amazon.Product_Details_Page;
import com.pages.amazon.Total_Summary_Page;

public class ValidateAmazon extends Base{
	@Test
	public void amazonEndtoEnd() {
		try {
		Home_Page home = new Home_Page(driver);
		Product_Details_Page details = new Product_Details_Page(driver);
		Total_Summary_Page cart = new Total_Summary_Page(driver);
		
		DecimalFormat formatter = new DecimalFormat("0.00");
		
		driver.get("https://www.amazon.in/");
		home.searchProduct("Toys");
		String product1SearchPrice = formatter.format(Double.parseDouble(home.fetchFirstProductPrice().replace(",", "")));
		String product2SearchPrice = formatter.format(Double.parseDouble(home.fetchSecondProductPrice().replace(",", "")));
		
		home.view1stProduct();
		switchToNewWindow();
		String product1DetailsPrice = formatter.format(Double.parseDouble(details.fetchProductPrice().replace(",", "")));
		details.clickAddToCart();
		closeWindow();
		
		home.view2ndProduct();
		switchToNewWindow();
		String product2DetailsPrice = formatter.format(Double.parseDouble(details.fetchProductPrice().replace(",", "")));
		details.clickAddToCart();
		closeWindow();
		
		home.viewCart();
		String product1CartPrice = formatter.format(Double.parseDouble(cart.fetchFirstProductPrice().replace(",", "")));
		String product2CartPrice = formatter.format(Double.parseDouble(cart.fetchSecondProductPrice().replace(",", "")));	
//		product1CartPrice = product1CartPrice.substring(0,product1CartPrice.length()-3);
//		product2CartPrice = product2CartPrice.substring(0,product2CartPrice.length()-3);
		
		//Validating Search prices with prices in Details Page
		System.out.println(product1SearchPrice);
		System.out.println(product2SearchPrice);
		System.out.println(product1DetailsPrice);
		System.out.println(product2DetailsPrice);
		System.out.println(product1CartPrice);
		System.out.println(product2CartPrice);
		
		Assert.assertEquals(product1DetailsPrice, product1SearchPrice);
		Assert.assertEquals(product2DetailsPrice, product2SearchPrice);
		
		//Validating Details prices with prices in cart Page
		Assert.assertEquals(product1CartPrice, product1DetailsPrice);
		Assert.assertEquals(product2CartPrice, product2DetailsPrice);
		
		//Validating Search prices with prices in Cart Page
		Assert.assertEquals(product1CartPrice, product1SearchPrice);
		Assert.assertEquals(product2CartPrice, product2DetailsPrice);
		
		String s = "hello";
		s.chars().mapToObj(c->(char)c).sorted().
		
		}
		catch(Exception e) {
			e.printStackTrace();
			driver.quit();
		}
	}
}
