package com.base;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {
	protected static WebDriver driver;
	public static String BASE_WINDOW_ID;
	@BeforeTest
	public void initDriver() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		BASE_WINDOW_ID = driver.getWindowHandle();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	public void switchToNewWindow() {
		Set<String> windows = driver.getWindowHandles();
		for(String window:windows) {
			if(!window.equals(BASE_WINDOW_ID)) {
				driver.switchTo().window(window);
				break;
			}
		}
	}
	
	public void switchToMainWindow() {
		driver.switchTo().window(BASE_WINDOW_ID);
	}
	
	public void closeWindow() {
		driver.close();
		switchToMainWindow();
	}
}
