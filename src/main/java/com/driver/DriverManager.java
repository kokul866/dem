package com.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	public static ThreadLocal<WebDriver> tw=new ThreadLocal<WebDriver>();
	public static void setdriver(WebDriver driver)
	{
		tw.set(driver);
	}
	
}
