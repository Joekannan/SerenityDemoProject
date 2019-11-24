package com.TWG.Mobile.pages.iOSPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.TWG.Mobile.pages.AppiumPageObject;

public class iOSProdListPage extends AppiumPageObject{

	public iOSProdListPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name = "Sort by")
	public WebElement btnSortBy;
	
	@FindBy(name = "Filter")
	public WebElement btnFilter;
	
	@FindBy(name = "backIndicator")
	public WebElement btnBack;
	
	@FindBy(name = "search icon bar item")
	public WebElement btnSearch;
	
	@FindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell")
	public List<WebElement> lstProducts;
	
	@FindBy(name = "add to wishlist card")
	public List<WebElement> lstWishLists;
	
	//(//XCUIElementTypeStaticText[@name="ONLINE ONLY"])[1]
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='ONLINE ONLY']")
	public List<WebElement> lblOnlineOnly;
	
}

