package com.TWG.Mobile.pages.iOSPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.TWG.Mobile.pages.AppiumPageObject;

public class iOSSearchPage extends AppiumPageObject {

	public iOSSearchPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name = "Search")
	public WebElement txtSearch;
	
	@FindBy(xpath = "//XCUIElementTypeTable[@name='Search results']/XCUIElementTypeCell")
	public List<WebElement> lstSearchResults;

}
