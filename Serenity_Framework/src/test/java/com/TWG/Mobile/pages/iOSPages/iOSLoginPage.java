package com.TWG.Mobile.pages.iOSPages;

import org.aspectj.weaver.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.TWG.Mobile.pages.AppiumPageObject;

public class iOSLoginPage extends AppiumPageObject {

	public iOSLoginPage(WebDriver driver) {
		super(driver);
	}
	Logger logger = LoggerFactory.getLogger(Utils.class);
	
	@FindBy(xpath = ".//XCUIElementTypeTextField[@value='Email address']")
	public WebElement txtEmail;
	
	@FindBy(xpath = ".//XCUIElementTypeSecureTextField[@value='Password']")
	public WebElement txtPassword;
	
	@FindBy(name = "Forgot password?")
	public WebElement btnForgotPwd;
	
	@FindBy(name = "SIGN IN")
	public WebElement btnSignIn;
	
	@FindBy(name = "Create New Account")
	public WebElement btnCreateAccount;
	
}
