package com.TWG.Mobile.pages;

import static org.junit.Assert.assertEquals;
import org.aspectj.weaver.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;

public class RegistrationPage extends AppiumPageObject {
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	Logger logger = LoggerFactory.getLogger(Utils.class);

	@FindBy(id="nz.co.thewarehouse.wow.qat:id/btn_register", timeoutInSeconds="10")
	public WebElement btnRegister;
	
	@FindBy(xpath=".//android.widget.TextView[@text='Create Account']", timeoutInSeconds="10")
	public WebElement lblRegisterHeader;
	
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/first_name", timeoutInSeconds="10")
	public WebElement txtFirstName;
	
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/last_name", timeoutInSeconds="10")
	public WebElement txtLastName;
	
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/email", timeoutInSeconds="10")
	public WebElement txtEmail;
	
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/password", timeoutInSeconds="10")
	public WebElement txtPassword;
	
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/text", timeoutInSeconds="10")
	public WebElement lblConfirmation;
	
	public void click_Register() {
		element(btnRegister).waitUntilClickable();
		btnRegister.click();
	}
	
	public void reg_Confirmation() {
		waitFor(ExpectedConditions.presenceOfElementLocated(By.id("nz.co.thewarehouse.wow.qat:id/text")));
		//Thanks for registering with us!
		String text = lblConfirmation.getText();
//		assertSame(text, text, text);
		assertEquals("Registration Confirmation Message","Thanks for registering with us!", text);
	}
	
	public String verify_RegistrationHeader() {
		String lblHeader = "";
		if(element(lblRegisterHeader).isPresent()) {
			lblHeader = lblRegisterHeader.getText();
		}
		else {
			logger.info("Registration Header element is not available");
		}
		return lblHeader;
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
	
}
