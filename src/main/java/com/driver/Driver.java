package com.driver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;

import com.utils.Constants;
import com.utils.Utilities;

public class Driver {
	public WebDriver driver;
	public WebDriver setdriver() throws IOException {
	/*	Properties p=new Properties();
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\browser.properties");
		p.load(file);
		String browsername=p.getProperty("browser"); */
		String browsername=Utilities.PropReader("browser");
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",Constants.driverpath);
			ChromeOptions op = new ChromeOptions();
			//op.addArguments("headless");
			driver = new ChromeDriver(op);
			//driver.get(p.getProperty("url"));
			driver.get(Utilities.PropReader("url"));
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DriverManager.setdriver(driver);
		return driver;
		
	}
	@AfterMethod
	public void tearup() {
		driver.close();
	}
	
	 

}
