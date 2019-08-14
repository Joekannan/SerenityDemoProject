package com.TWG.Mobile.pages;

import java.util.List;

import org.aspectj.weaver.Utils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.annotations.findby.FindBy;


public class MyAccountPage extends AppiumPageObject {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	Logger logger = LoggerFactory.getLogger(Utils.class);
	
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/tv_user_name", timeoutInSeconds="10")
	public WebElement lblLoginUserName;
	
	@FindBy(xpath=".//android.widget.TextView[@text='My Account']", timeoutInSeconds="10")
	public WebElement lblMyAccount;
//	public static final By strlblMyAccount = By.xpath(".//android.widget.TextView[@text='My Account']");
	
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/label", timeoutInSeconds="10")
	public List<WebElement> lblOptions;
	
	//text	Store Receipts
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/content_ct", timeoutInSeconds="10")
	public List<WebElement> lstReceipts;
	
	@FindBy(xpath=".//android.widget.TextView[@text='Store Receipts']", timeoutInSeconds="10")
	public WebElement lblStoreReceipts;
	
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/empty_screen_heading", timeoutInSeconds="10")
	public WebElement lblNoReceipts;//You have not added any Store Receipts yet
	
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/btn_add_receipt", timeoutInSeconds="10")
	public WebElement btnAddReceipt;
	
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/fab_scan_receipt", timeoutInSeconds="10")
	public WebElement btnScanReceipt;
	
	//text	Online Orders
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/content_ct", timeoutInSeconds="10")
	public List<WebElement> lstOrders;
	
	@FindBy(xpath=".//android.widget.TextView[@text='Online Orders']", timeoutInSeconds="10")
	public WebElement lblOrders;
	
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/empty_screen_heading", timeoutInSeconds="10")
	public WebElement lblNoOrders;//You have not placed any order yet
	
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/btn_start_exploring", timeoutInSeconds="10")
	public WebElement btnStartExploring; // Takes the user to Browse Category page
	
	//text	Wish List
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/product_item_container", timeoutInSeconds="10")
	public List<WebElement> lstWishList;
	
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/circle", timeoutInSeconds="10")
	public WebElement btnHeart;
	
	@FindBy(xpath=".//android.widget.TextView[@text='Wishlist']", timeoutInSeconds="10")
	public WebElement lblWishList; // Selected attribute is set true
	
	@FindBy(id="android:id/alertTitle", timeoutInSeconds = "10")
	public WebElement alertRemove;//text	Remove Item?
	
	@FindBy(id="android:id/button1", timeoutInSeconds = "10")
	public WebElement alertBtnRemove;
	
	@FindBy(id="android:id/button2", timeoutInSeconds = "10")
	public WebElement alertBtnCancel;
	
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/empty_screen_heading", timeoutInSeconds = "10")
	public WebElement lblNoWishList; //text	Your Wishlist will live here
	
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/btn_start_exploring", timeoutInSeconds = "10")
	public WebElement lnkStartExploring; 
	
	//text	Delivery Addresses
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/tv_address", timeoutInSeconds="10")
	public List<WebElement> lstAddress;
	
	@FindBy(xpath=".//android.widget.TextView[@text='Delivery Addresses']", timeoutInSeconds="10")
	public WebElement lblAddress;
	
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/add_delivery_label", timeoutInSeconds="10")
	public WebElement btnAddAddress;
	
	//text	Manage Credit Cards
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/card_item_container", timeoutInSeconds="10")
	public List<WebElement> lstSavedCards;
	
	@FindBy(xpath=".//android.widget.TextView[@text='Manage Credit Cards']", timeoutInSeconds="10")
	public WebElement lblCards;
	
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/empty_screen_heading", timeoutInSeconds = "10")
	public WebElement lblNoSavedCards; //text	You don’t have any saved cards yet
	
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/btn_delete", timeoutInSeconds="10")
	public WebElement btnCardDelete;
	
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/btn_make_default", timeoutInSeconds="10")
	public WebElement btnCardDefault;
	
	@FindBy(accessibilityId="Navigate up", timeoutInSeconds="10")
	public WebElement btnBack;
	
	@FindBy(className="android.widget.ImageButton", timeoutInSeconds="10")
	public WebElement menuHamBurger;
	
//############################################################################################################
//Function Name:		click_myAccount 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to click on the user email from the hamburger menu to access so many options
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	
	public void click_myAccount() {
		try {
			clickOn(lblLoginUserName);
			if(isElementPresent(lblMyAccount))
			{
				String title = lblMyAccount.getText();
				Assert.assertEquals("Validating My Account Title", title, "My Account");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
//############################################################################################################
//Function Name:		myAccount_options 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to validate the list of options under my account
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	
	public void myAccount_options() {
		try {
			List<WebElement> lblOptions = driver.findElements(By.id("nz.co.thewarehouse.wow.qat:id/label"));
			for (WebElement lblOption : lblOptions) {
				String label = lblOption.getText();
				
				switch(label){
				
				case "Store Receipts" :
					clickOn(lblOption);
					waitFor(5000);
					if(isElementPresent(lblStoreReceipts)) {
						if(isElementVisible(By.id("nz.co.thewarehouse.wow.qat:id/empty_screen_heading"))) {
							Assert.assertEquals("No Store Receipts", "You have not added any Store Receipts yet", lblNoReceipts.getText());
						}
						else if(lstReceipts.size()>1) {
							logger.info("Number of receipts displayed for this user is " + lstReceipts.size());
						}
					}
					else {
						logger.info("User is not in Store Receipts page. Something went wrong");
					}
					clickOn(btnBack);
					break;
					
				case "Online Orders" :
					clickOn(lblOption);
					waitFor(5000);
					if(isElementPresent(lblOrders)) {
						if(isElementVisible(By.id("nz.co.thewarehouse.wow.qat:id/empty_screen_heading"))) {
							Assert.assertEquals("No Online Orders", "You have not placed any order yet", lblNoReceipts.getText());
						}
						else if(lstOrders.size()>1) {
							logger.info("Number of orders displayed for this user is " + lstOrders.size());
						}
					}
					else {
						logger.info("User is not in Online Orders page. Something went wrong");
					}
					clickOn(btnBack);
					break;
					
				case "Wish List" :
//					clickOn(lblOption);
//					if(isElementPresent(lblWishList)) {
//						if(isElementVisible(By.id("nz.co.thewarehouse.wow.qat:id/empty_screen_heading"))) {
//							Assert.assertEquals("No Items in Wishlist", "Your Wishlist will live here", lblNoReceipts.getText());
//						}
//						else if(lstWishList.size()>1) {
//							logger.info("Number of items in wishlist for this user is " + lstWishList.size());
//						}
//					}
//					else {
//						logger.info("User is not in the wish list page. Something went wrong");
//					}
//					clickOn(menuHamBurger);
//					waitFor(5000);
//					clickOn(lblLoginUserName);
					break;
					
				case "Delivery Addresses" :
					clickOn(lblOption);
					waitFor(5000);
					if(isElementPresent(lblAddress)) {
						if(lstAddress.size()==0) {
							logger.info("No Delivery Address is stored");
						}
						else if(lstAddress.size()>1) {
							logger.info("Number of Delivery Address stored for this user is " + lstAddress.size());
						}
					}
					else {
						logger.info("User is not in the Delivery Addresses page. Something went wrong");
					}
					clickOn(btnBack);
					break;
				
				case "Manage Credit Cards":
					clickOn(lblOption);
					waitFor(5000);
					if(isElementPresent(lblCards)) {
						if(isElementVisible(By.id("nz.co.thewarehouse.wow.qat:id/empty_screen_heading"))) {
							Assert.assertEquals("No cards in saved card list", "You don’t have any saved cards yet", lblNoSavedCards.getText());
						}
						else if(lstSavedCards.size()>1) {
							logger.info("Number of saved cards for this user is " + lstSavedCards.size());
						}
					}
					else {
						logger.info("User is not in the Manage Credit Cards page. Something went wrong");
					}
					clickOn(btnBack);
					break;
					
				default:
					break;
				
				
				}
				lblOptions = driver.findElements(By.id("nz.co.thewarehouse.wow.qat:id/label"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
