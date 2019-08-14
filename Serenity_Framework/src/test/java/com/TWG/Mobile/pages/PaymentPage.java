package com.TWG.Mobile.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import net.serenitybdd.core.annotations.findby.FindBy;

public class PaymentPage extends AppiumPageObject{

	public PaymentPage(WebDriver driver) {
		super(driver);
	}
	public String orderNum = "";

	@FindBy(id = "nz.co.thewarehouse.wow.qat:id/order_number", timeoutInSeconds = "10")
	public WebElement lblOrderNumber;
	
	public static final By txtCardNumber =By.xpath("//android.view.View[contains(@text,'Card Number')][1]/following-sibling::android.view.View/android.widget.EditText");
	public static final By txtNameOnCard =By.xpath("//android.view.View[contains(@text,'Name On Card')][1]/following-sibling::android.view.View/android.widget.EditText");
	public static final By txtSecurityCode =By.xpath("//android.view.View[contains(@text,'Security code')][1]/following-sibling::android.view.View/android.widget.EditText");
	public static final By btnPlaceOrder =By.xpath("//android.widget.Button[@text='Place order now']");
	public static final By lstExpiryDate =By.className("android.widget.Spinner");
	public static final By radioYear =By.xpath(".//android.widget.CheckedTextView[@text='23']");
	
	
	@SuppressWarnings("rawtypes")
	public void enterCardNumber(String cardNumber) {
		waitFor(20000);
//		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);" , driver.findElement(txtCardNumber));
		try {
			swipeToElement();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(txtCardNumber).click();
		driver.findElement(txtCardNumber).sendKeys(cardNumber);
	    ((AppiumDriver)driver).hideKeyboard();
	   }
	
	@SuppressWarnings("rawtypes")
	public void enterNameonCard(String name) {
		waitFor(10000);
	    clickOn(driver.findElement(txtNameOnCard)); 
	    driver.findElement(txtNameOnCard).sendKeys(name);
	    ((AppiumDriver)driver).hideKeyboard();
	}
	
	@SuppressWarnings("rawtypes")
	public void enterSecurityCode(String code) {
		waitFor(10000);
	    clickOn(driver.findElement(txtSecurityCode));   
	    driver.findElement(txtSecurityCode).sendKeys(code);
	    ((AppiumDriver)driver).hideKeyboard();
	}
	
	@SuppressWarnings("rawtypes")
	public void setExpiryDate() {
		waitFor(10000);
		int len = driver.findElements(lstExpiryDate).size();
		driver.findElements(lstExpiryDate).get(len-1).click();
		driver.findElement(radioYear).click();
		((AppiumDriver)driver).hideKeyboard();
		
	}
	
	public void clickPlaceOrder() {
		driver.findElement(btnPlaceOrder).click();
	}
	
	public String fetchOrderNumber() {
		waitFor(30000);
	    waitFor(ExpectedConditions.presenceOfElementLocated(By.id("nz.co.thewarehouse.wow.qat:id/order_number")));
		orderNum = lblOrderNumber.getText().split("Order Number: ")[1];
		return orderNum;
	}
}
