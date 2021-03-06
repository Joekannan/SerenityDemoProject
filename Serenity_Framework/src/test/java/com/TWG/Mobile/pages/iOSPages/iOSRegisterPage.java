package com.TWG.Mobile.pages.iOSPages;

import static org.junit.Assert.assertEquals;

import org.aspectj.weaver.Utils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.TWG.Mobile.pages.AppiumPageObject;

import net.serenitybdd.core.annotations.findby.By;

public class iOSRegisterPage extends AppiumPageObject{

	public iOSRegisterPage(WebDriver driver) {
		super(driver);
	}
	Logger logger = LoggerFactory.getLogger(Utils.class);
	
	@FindBy(xpath = ".//XCUIElementTypeTextField[@value='First Name']")
	public WebElement txtFirstName;
	
	@FindBy(xpath = ".//XCUIElementTypeTextField[@value='Last Name']")
	public WebElement txtLastName;
	
	@FindBy(xpath = ".//XCUIElementTypeTextField[@value='Email']")
	public WebElement txtEmail;
	
	@FindBy(xpath = ".//XCUIElementTypeSecureTextField[@value='Password']")
	public WebElement txtPassword;
	
	@FindBy(name = "REGISTER")
	public WebElement btnRegister;
	
	@FindBy(name = "Login")
	public WebElement btnLogin;
	
	@FindBy(xpath = "//XCUIElementTypeOther[@name='Registration']")
	public WebElement lblRegisterHeader;
	
	@FindBy(name = "Cancel")
	public WebElement btnCancel;
	
	@FindBy(name = "account-big")
	public WebElement lblConfirmation;
	
	@FindBy(name = "Save Password")
	public WebElement btnSavePwd;
	
	@FindBy(name = "Not Now")
	public WebElement btnNotSavePwd;
	
	
	public void click_Register() {
		element(btnRegister).waitUntilClickable();
		btnRegister.click();
	}
	
	public void input_text(WebElement we, String text) {
		element(we).waitUntilClickable();
		we.click();
		we.clear();
		we.sendKeys(text);
	}
	
	public String firstName() {
		String FirstName = nameGenrator();
		return FirstName;
	}
	
	public String lastName() {
		String LastName = nameGenrator();
		return LastName;
	}
	
	public String email() {
		String Email = emailGenerator();
		return Email;
	}
	
	public String password() {
		String Password = passwordGenerator();
		return Password;
	}
	
	public String verify_RegistrationHeader() {
		String lblHeader = "";
		if(element(lblRegisterHeader).isPresent()) {
			lblHeader = lblRegisterHeader.getText();
		}
		else {
			logger.info("Registration Header is not available");
		}
		return lblHeader;
	}
	
	public boolean reg_Confirmation() {
		Boolean blnFlag = false;
		waitFor(5000);
//		driver.switchTo().alert().dismiss();
//		if(isElementPresent(btnNotSavePwd)) {
//			clickOn(btnNotSavePwd);
//			waitFor(5000);
//		}
		waitFor(ExpectedConditions.presenceOfElementLocated(By.name("account-big")));
		if(isElementPresent(lblConfirmation)) {
			blnFlag = true;
		}
		else {
			blnFlag = false;
			}
		return blnFlag;
		
	}
}

	