package com.TWG.Mobile.pages;

import org.aspectj.weaver.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.appium.java_client.MobileBy;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.screenplay.targets.Target;


public class LoginPage extends AppiumPageObject{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	Logger logger = LoggerFactory.getLogger(Utils.class);
	
	public static final Target BOX_CHAT = 
            Target.the("box chat filed")
                        .locatedForAndroid(MobileBy.id("android_element_id"))
                        .locatedForIOS(MobileBy.id("iOS_element_id"));
	
	@FindBy(className="android.widget.ImageButton", timeoutInSeconds="10")
	public WebElement menuHamBurger;
	
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/btn_login", timeoutInSeconds="10")
	public WebElement btnlogin;
	
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/email", timeoutInSeconds="10")
	public WebElement txtUserName;
	
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/password", timeoutInSeconds="10")
	public WebElement txtPassword;
	
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/login_btn", timeoutInSeconds="10")
	public WebElement btnSignin;
	
	@FindBy(id="")
	public WebElement btnSignout;
	 
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/title", timeoutInSeconds="10")
	public WebElement lblLoginMessage;
	
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/tv_user_email", timeoutInSeconds="10")
	public WebElement lblLoginUserEmail;

//############################################################################################################
//Function Name:		click_Menu 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to click the hamburger menu to access so many options
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	
	public void click_Menu() {
		try {
			waitFor(10000);
			waitFor(ExpectedConditions.presenceOfElementLocated(By.className("android.widget.ImageButton")));
			menuHamBurger.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
//############################################################################################################
//Function Name:		click_Login 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to click the login button from the menu
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	
	public void click_Login() {
		try {
			btnlogin.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
//############################################################################################################
//Function Name:		enter_UserName 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to enter username
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	
	public void enter_UserName(String username) {
		try {
			txtUserName.clear();
			txtUserName.click();
			txtUserName.sendKeys(username);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
//############################################################################################################
//Function Name:		enter_Password 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to enter the password
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	
	public void enter_Password(String password) {
		try {
			txtPassword.clear();
			txtPassword.click();
			txtPassword.sendKeys(password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
//############################################################################################################
//Function Name:		click_Signin 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to click the sign in button after enter username and password
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	
	public void click_Signin() {
		try {
			btnSignin.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
//############################################################################################################
//Function Name:		waitForMenu 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to wait for a menu icon to appear for an action
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	
	public void waitForMenu() {
		try {
			waitFor(10000);
			waitFor(ExpectedConditions.elementToBeClickable(menuHamBurger));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//############################################################################################################
//Function Name:		validate_LoginFailure 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to verify the failure login
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	
	public String validate_LoginFailure() {
		String txtLoginStatus = null;
		try {
			if(isElementPresent(lblLoginMessage)) {
				txtLoginStatus = lblLoginMessage.getText();
			}
			else {
				logger.info("Login Failure message is not available.");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return txtLoginStatus;
	}
	
//############################################################################################################
//Function Name:		validate_LoginSuccess 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to verify the successful login
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	
	public String validate_LoginSuccess() {
		String txtLoginStatus = "";
		try {
			
			if(isElementPresent(lblLoginUserEmail)) {
				txtLoginStatus = lblLoginUserEmail.getText();
			}
			else {
				logger.info("Email address for successful login is not validated.");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return txtLoginStatus;
	}
}
