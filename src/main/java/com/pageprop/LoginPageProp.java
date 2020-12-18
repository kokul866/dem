package com.pageprop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageProp {
	WebDriver driver;
	public LoginPageProp(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='uid']") WebElement username;
	@FindBy(xpath="//input[@name='password']") WebElement password;
	@FindBy(xpath="//input[@name='btnLogin']") WebElement login;
	
	public void getusername(String value) {
		 username.sendKeys(value);
	}
	public void getpassword(String value) {
		password.sendKeys(value);
	}
	public void getlogin() {
		 login.click();
	}
	

}
