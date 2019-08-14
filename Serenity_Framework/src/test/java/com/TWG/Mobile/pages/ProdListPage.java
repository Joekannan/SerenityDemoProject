package com.TWG.Mobile.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import net.serenitybdd.core.annotations.findby.FindBy;

public class ProdListPage extends AppiumPageObject {

	public ProdListPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="nz.co.thewarehouse.wow.qat:id/product_item_container", timeoutInSeconds="10")
	public List <WebElement> PLPs;
	
	int Size = PLPs.size();
	
	public void selectProductfromPLP() {
			waitFor(5000);
			waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("nz.co.thewarehouse.wow.qat:id/product_item_container")));
			clickOn(PLPs.get(1));
		}
	}
	
