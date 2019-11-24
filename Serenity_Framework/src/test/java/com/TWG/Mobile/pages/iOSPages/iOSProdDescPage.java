package com.TWG.Mobile.pages.iOSPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.TWG.Mobile.pages.AppiumPageObject;

public class iOSProdDescPage extends AppiumPageObject {

	public iOSProdDescPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(name = "Back")
	public WebElement btnBack;
	
	@FindBy(name = "search icon bar item")
	public WebElement btnSearch;
	
	
}
