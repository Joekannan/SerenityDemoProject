package com.TWG.Mobile.pages;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;

public class CartPage extends AppiumPageObject {

	public CartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="nz.co.thewarehouse.wow.qat:id/radio_home_delivery", timeoutInSeconds = "10")
	public WebElement radioHomeDelivery;
	
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/radio_pick_up_in_store", timeoutInSeconds = "10")
	public WebElement radioClickCollect;
	
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/btn_next", timeoutInSeconds = "10")
	public WebElement btnCheckOut;
	
	@FindBy(xpath=".//android.widget.Button[@content-desc='Remove item']", timeoutInSeconds = "10")
	public List<WebElement> btnRemove;
	
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/alertTitle", timeoutInSeconds = "10")
	public WebElement alertRemove;//text	Remove Item?
	
	@FindBy(id="android:id/button1", timeoutInSeconds = "10")
	public WebElement alertBtnRemove;
	
	@FindBy(id="android:id/button2", timeoutInSeconds = "10")
	public WebElement alertBtnCancel;
	
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/empty_screen_heading", timeoutInSeconds = "10")
	public WebElement lblEmptyCart; //text	There are no items in your cart yet
	
	
//############################################################################################################
//Function Name:		selectDeliveryMethod 
//Input Parameter:		deliveryMethod
//Output Parameter:		None
//Description:			This function is used to select the delivery method during checkout journey
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	public void selectDeliveryMethod(String deliveryMethod) {
		try {
			switch(deliveryMethod) {
			case "Home Delivery" :
				element(radioHomeDelivery).waitUntilClickable();
				radioHomeDelivery.click();
				break;
			case "Click and Collect" :
				element(radioClickCollect).waitUntilClickable();
				radioClickCollect.click();
				break;
			default:
				break;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
//############################################################################################################
//Function Name:		clickCheckOut 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to click the checkout button during checkout journey
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	public void clickCheckOut() {
		try {
			element(btnCheckOut).waitUntilClickable();
			btnCheckOut.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//############################################################################################################
//Function Name:		clickRemoveFromCart 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to remove an item from the cart
//Tester:				Nagajothi Kaliappan
//############################################################################################################	

	public void clickRemoveFromCart() {
		try {
			int Size = btnRemove.size();
			if(Size == 1) {
				btnRemove.get(Size-1).click();
				element(alertRemove).waitUntilPresent();
				if(isElementPresent(alertRemove)) {
					String text = alertRemove.getText().trim();
					assertEquals(text, "Remove Item?");
					clickOn(alertBtnRemove);
				}
			}
			else {
				for(WebElement btnRem : btnRemove) {
					btnRem.click();
					element(alertRemove).waitUntilPresent();
					if(isElementPresent(alertRemove)) {
						String text = alertRemove.getText().trim();
						assertEquals(text, "Remove Item?");
						clickOn(alertBtnRemove);
					}
				}
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
	
//############################################################################################################
//Function Name:		validateEmptyCart 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to validate the empty cart message
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	public void validateEmptyCart() {
		try {
			if(isElementPresent(lblEmptyCart)) {
				String lblEmptyMsg = lblEmptyCart.getText();
				Assert.assertEquals("Empty Cart Message", "There are no items in your cart yet", lblEmptyMsg);
			}
			else {
				System.out.println("Something wrong in the cart page. Cart is not empty");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
