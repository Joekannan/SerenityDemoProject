package com.TWG.Mobile.pages;

import java.util.List;
import java.util.Set;

import org.apache.commons.text.RandomStringGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.locators.WaitForWebElementCollection;
import net.thucydides.core.webdriver.WebDriverFacade;

public class CheckOutPage extends AppiumPageObject {

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = ".//android.widget.RadioButton[@text='Credit Card']", timeoutInSeconds="10")
	public WebElement radioCC;
	
	@FindBy(xpath = ".//android.widget.RadioButton[@text='Warehouse Money Card']", timeoutInSeconds="10")
	public WebElement radioWMC;
	
	@FindBy(xpath = ".//android.widget.RadioButton[@text='PartPay']", timeoutInSeconds="10")
	public WebElement radioPP;

	@FindBy(id = "nz.co.thewarehouse.wow.qat:id/btn_next", timeoutInSeconds="10")
	public WebElement btnPayment;
	
	@FindBy(xpath = ".//android.widget.TextView[@text='Delivery Address']//following-sibling::android.widget.Button", timeoutInSeconds="10")
	public WebElement btnAddDeliAddress;
	
	@FindBy(xpath = ".//android.widget.TextView[@text='Delivery Instructions']//following-sibling::android.widget.Button", timeoutInSeconds="10")
	public WebElement btnAddDeliInstruction;
	
	@FindBy(id = "nz.co.thewarehouse.wow.qat:id/delivery_instructions", timeoutInSeconds="10")
	public WebElement txtDeliInstruction;
	
	@FindBy(id = "nz.co.thewarehouse.wow.qat:id/btn_cancel", timeoutInSeconds="10")
	public WebElement btnCancel;
	
	@FindBy(id = "nz.co.thewarehouse.wow.qat:id/btn_ok", timeoutInSeconds="10")
	public WebElement btnOK;
	
	@FindBy(id = "nz.co.thewarehouse.wow.qat:id/delivery_req_signature", timeoutInSeconds="10")
	public WebElement toggleDeliSign;
	
	
//############################################################################################################
//Function Name:		selectPaymentMethod 
//Input Parameter:		paymentMethod
//Output Parameter:		None
//Description:			This function is used to select the different payment method on check out page
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
			
	public void selectPaymentMethod(String paymentMethod) throws InterruptedException {
		try {
			waitFor(3000);
			switch(paymentMethod){
				case "Credit Card":
					Boolean blnFlag = false;
					blnFlag = isElementVisible(By.xpath(".//android.widget.RadioButton[@text='Credit Card']"));
					System.out.println(blnFlag);
					if (!blnFlag) {
						swipeToElement();
						waitFor(5000);
						waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(".//android.widget.RadioButton[@text='Credit Card']")));
						radioCC.click();
						break;
					}
					else {
						waitFor(5000);
						waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(".//android.widget.RadioButton[@text='Credit Card']")));
						radioCC.click();
						break;
					}
				case "Warehouse Money Card":
					Boolean blnFlag1 = false;
					blnFlag1 = isElementVisible(By.xpath(".//android.widget.RadioButton[@text='Warehouse Money Card']"));
					System.out.println(blnFlag1);
					if (!blnFlag1) {
						swipeToElement();
						waitFor(5000);
						waitFor(ExpectedConditions.elementToBeClickable(radioWMC));
						radioWMC.click();
						break;
					}
					else {
						waitFor(5000);
						waitFor(ExpectedConditions.elementToBeClickable(radioWMC));
						radioWMC.click();
						break;
					}
				case "PartPay":
					Boolean blnFlag11 = false;
					blnFlag11 = isElementVisible(By.xpath(".//android.widget.RadioButton[@text='Warehouse Money Card']"));
					System.out.println(blnFlag11);
					if (!blnFlag11) {
						swipeToElement();
						waitFor(5000);
						waitFor(ExpectedConditions.elementToBeClickable(radioPP));
						radioPP.click();
						break;
					}
					else {
						waitFor(5000);
						waitFor(ExpectedConditions.elementToBeClickable(radioPP));
						radioPP.click();
						break;
					}
				default:
					break;
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
//############################################################################################################
//Function Name:		clickPayment 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to click the payment button on check out page
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	
	public void clickPayment() {
		try {
			waitFor(10000);
			waitFor(ExpectedConditions.presenceOfElementLocated(By.id("nz.co.thewarehouse.wow.qat:id/btn_next")));
			clickOn(btnPayment);
			waitFor(5000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
//############################################################################################################
//Function Name:		clickAddDeliveryAddress 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to click the Add button to add new delivery addresses
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	
	public void clickAddDeliveryAddress() {
		try {
			if(isElementPresent(btnAddDeliAddress)) {
				clickOn(btnAddDeliAddress);
				waitFor(AddressPage.txtAddressSearch);
			}
			waitFor(5000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

//############################################################################################################
//Function Name:		enableDeliverySign 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to enable the delivery signature required
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	
	public void enableDeliverySign() {
		try {
			if(isElementPresent(toggleDeliSign)) {
				clickOn(toggleDeliSign);
			}
			waitFor(5000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}	
	
//############################################################################################################
//Function Name:		clickAddDeliInstruction 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to click add button for delivery instructions
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	
	public void clickAddDeliInstruction() {
		try {
			if(isElementPresent(btnAddDeliInstruction)) {
				clickOn(btnAddDeliInstruction);
			}
			waitFor(5000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}	
//############################################################################################################
//Function Name:		enterDeliveryInstruction 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to enter the delivery instructions
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	
	public void enterDeliveryInstruction() {
		try {
			if(isElementPresent(txtDeliInstruction)) {
				typeInto(txtDeliInstruction, "Ring the bell");
				clickOn(btnOK);
			}
			waitFor(15000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
