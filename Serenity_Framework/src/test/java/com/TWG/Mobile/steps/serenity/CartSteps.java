package com.TWG.Mobile.steps.serenity;

import org.aspectj.weaver.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.TWG.Mobile.pages.CartPage;
import com.TWG.Mobile.pages.PaymentPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CartSteps extends ScenarioSteps{
	Logger logger = LoggerFactory.getLogger(Utils.class);
	
	CartPage cartPage;
	
	@Step
	public void removeFromCart() {
		cartPage.clickRemoveFromCart();
	}
	
	@Step
	public void emptyCartMsg() {
		cartPage.validateEmptyCart();
	}
	
}
