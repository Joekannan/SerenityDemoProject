package com.TWG.Mobile.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.webdriver.WebDriverFacade;

public class ProdDescPage extends AppiumPageObject {

	public ProdDescPage(WebDriver driver) {
		super(driver);
	}
	
	String text = "ADD TO CART";
	
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/add_to_cart", timeoutInSeconds = "10")
	public WebElement btnAddToCart;
	
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/action_cart", timeoutInSeconds="10")
	public WebElement btnGetCart;
	
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/btn_register", timeoutInSeconds = "10")
	public WebElement lnkRegister;
	
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/btn_sign_in", timeoutInSeconds = "10")
	public WebElement lnkSignIn;
	
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/tv_do_not_ask_me_again", timeoutInSeconds = "10")
	public WebElement lnkDontAskMeAgain;
	
	public final By bylnkDontAskMeAgain = By.id("nz.co.thewarehouse.wow.qat:id/tv_do_not_ask_me_again");
	
//	WebElement element = driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"nz.co.thewarehouse.wow.qat:id/add_to_cart\"))"));
	
//	WebElement element = driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"nz.co.thewarehouse.wow.qat:id/add_to_cart\")).scrollIntoView("
//				+ "new UiSelector().text(\"ADD TO CART\"))"));

//	@AndroidFindBy(uiAutomator="new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"" + text + "\"));")
//	WebElement btnAddToCart = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceIdMatches(\".*id/nz.co.thewarehouse.wow.qat:id/add_to_cart\")"));
	
//	@AndroidFindBy(uiAutomator="new UiSelector().resourceIdMatches(\".*id/nz.co.thewarehouse.wow.qat:id/add_to_cart\")")
//	public WebElement btnAddToCart;
	
//############################################################################################################
//Function Name:		addToCart 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to add an item to the cart
//Tester:				Nagajothi Kaliappan
//############################################################################################################		
	public void addToCart() {
//		scrollToAnElementByText((AppiumDriver<WebElement>) driver, text);
//		scrollToElement(btnAddToCart);
//		waitUntilElementPresent(btnAddToCart, By.id("nz.co.thewarehouse.wow.qat:id/add_to_cart"));
//		swipeToElement();
//		scrollToAnElementByExactText((AppiumDriver<WebElement>)driver, text, "nz.co.thewarehouse.wow.qat:id/add_to_cart");
		try {
			Boolean blnFlag = false;
			blnFlag = isElementVisible(By.id("nz.co.thewarehouse.wow.qat:id/add_to_cart"));
			System.out.println(blnFlag);
			if (!blnFlag) {
				scrollToAnElementByText((AppiumDriver<WebElement>)driver, text);
				clickOn(btnAddToCart);
				//Guest user - pop up to register / sign in
				if(isElementPresent(lnkDontAskMeAgain)) {
					clickOn(lnkDontAskMeAgain);
				}
			}
			else {
				clickOn(btnAddToCart);
				//Guest user - pop up to register / sign in
				if(isElementPresent(lnkDontAskMeAgain)) {
					clickOn(lnkDontAskMeAgain);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
//############################################################################################################
//Function Name:		getCart 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to skip login / registration - Continue as a guest for the actions
//Tester:				Nagajothi Kaliappan
//############################################################################################################		
	public void getCart() {
		try {
			waitFor(5000);
			waitFor(ExpectedConditions.presenceOfElementLocated(By.id("nz.co.thewarehouse.wow.qat:id/action_cart")));
			clickOn(btnGetCart);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

//############################################################################################################
//Function Name:		skipLoginOrReg 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to skip login / registration - Continue as a guest for the actions
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	public void skipLoginOrReg() {
		try {
			if(isElementVisible(bylnkDontAskMeAgain)) {
				element(lnkDontAskMeAgain).waitUntilClickable();
				lnkDontAskMeAgain.click();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}	
}
