package com.TWG.Mobile.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.annotations.findby.FindBy;

public class SearchPage extends AppiumPageObject {
	
	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	String text;
	
	
//	@FindBy(xpath="//android.widget.TextView[@content-desc='Search']", timeoutInSeconds="10")
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/action_search", timeoutInSeconds="10")
//	@AndroidFindBy(id="nz.co.thewarehouse.wow.qat:id/action_search")
	public WebElement btnSearch;
	
//	@FindBy(className="android.widget.EditText", timeoutInSeconds="10")
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/tv_search", timeoutInSeconds="10")
//	@AndroidFindBy(id="nz.co.thewarehouse.wow.qat:id/tv_search")
	public WebElement txtSearch;
	
//	@FindBy(xpath=".//android.widget.TextView[@resource-id='nz.co.thewarehouse.wow.qat:id/tv_suggestion'][contains(@text,'Rings')]", timeoutInSeconds="10")
	@FindBy(xpath=".//android.widget.TextView[@resource-id='nz.co.thewarehouse.wow.qat:id/tv_suggestion']", timeoutInSeconds="10")
//	@AndroidFindBy(xpath=".//android.widget.TextView[@resource-id='nz.co.thewarehouse.wow.qat:id/tv_suggestion']")
	public List<WebElement> searchResults;
	
	@FindBy(id="nz.co.thewarehouse.wow.qat:id/tv_result_summary")
	public WebElement lnkResultSummary;
	
	public void clickSearch() throws InterruptedException {
		waitFor(5000);
		waitFor(ExpectedConditions.presenceOfElementLocated(By.id("nz.co.thewarehouse.wow.qat:id/action_search")));
		btnSearch.click();
	}
	
	public void enterSearchText(String text) {
		txtSearch.clear();
		txtSearch.click();
		txtSearch.sendKeys(text);
	}
	
	public void resultClick() {
		waitFor(5000);
		if(isElementVisible(By.xpath(".//android.widget.TextView[@resource-id='nz.co.thewarehouse.wow.qat:id/tv_suggestion']"))) {
			waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//android.widget.TextView[@resource-id='nz.co.thewarehouse.wow.qat:id/tv_suggestion']")));
			for(WebElement searchResult : searchResults) {
				element(searchResult).waitUntilVisible();
				searchResult.click();
				break;
			}
		}
		else if(isElementPresent(lnkResultSummary)) {
			clickOn(lnkResultSummary);
		}
	}
}
