package com.TWG.Mobile.pages.iOSPages;

import org.aspectj.weaver.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.TWG.Mobile.pages.AppiumPageObject;

public class iOSHomePage extends AppiumPageObject {

	public iOSHomePage(WebDriver driver) {
		super(driver);
	}
	
	Logger logger = LoggerFactory.getLogger(Utils.class);

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Home']")
	public WebElement btnHome;
	
	@FindBy(name = "Browse")
	public WebElement btnBrowse;
	
	@FindBy(name = "Cart")
	public WebElement btnCart;
	
	@FindBy(name = "Wishlist")
	public WebElement btnWishlist;
	
	@FindBy(name = "Account")
	public WebElement btnAccount;
	
	@FindBy(name = "scan search")
	public WebElement btnScan;
	
	@FindBy(name = "Help")
	public WebElement btnHelp;
	
	@FindBy(name = "Search")
	public WebElement txtSearch;
	
	@FindBy(name = "outlineCamera")
	public WebElement btnCamera;
	
	public void click_Account() {
		element(btnAccount).waitUntilClickable();
		btnAccount.click();
	}
	
}
