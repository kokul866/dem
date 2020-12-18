package com.tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dataprovider.Dataprovider;
import com.driver.Driver;
import com.pageprop.LoginPageProp;
import com.sun.tools.sjavac.Log;
import com.utils.Utilities;

public class LoginPage extends Driver{
	Logger log=LogManager.getLogger(Driver.class.getName());
	public WebDriver driver;
	@Test(dataProvider="logdata",dataProviderClass=Dataprovider.class)
	public void login(String value1,String value2) throws IOException, InterruptedException {
		driver=setdriver();
		log.info("LANDED TO THE LOGIN PAGE");
		LoginPageProp lp=new LoginPageProp(driver);
		lp.getusername(value1);
		lp.getpassword(value2);
		lp.getlogin();
		Thread.sleep(3000);
		if(Utilities.isalertpresent(driver)==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			System.out.println("LOGIN FAILED");
			log.info("LOGIN FAILED");
			Assert.assertTrue(false);
		}
		else {
			Assert.assertEquals(driver.getCurrentUrl(),"http://demo.guru99.com/V1/html/Managerhomepage.php");
			System.out.println("LOGIN SUCESSFULL");
			log.info("LOGIN SUCCESSFULL");
		}
		
	}

}
