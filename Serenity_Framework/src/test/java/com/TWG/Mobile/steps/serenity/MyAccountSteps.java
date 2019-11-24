package com.TWG.Mobile.steps.serenity;

import org.aspectj.weaver.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.TWG.Mobile.pages.MyAccountPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class MyAccountSteps extends ScenarioSteps {
	
	MyAccountPage myaccountPage;
	
	Logger logger = LoggerFactory.getLogger(Utils.class);
	
	@Step
	public void clickMyAccount() throws Throwable {
		myaccountPage.click_myAccount();
	}
	
	@Step
	public void validateMyAccount() throws Throwable {
		myaccountPage.myAccount_options();
	}

}
