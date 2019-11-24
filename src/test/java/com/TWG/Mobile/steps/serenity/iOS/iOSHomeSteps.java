package com.TWG.Mobile.steps.serenity.iOS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.TWG.Mobile.pages.iOSPages.iOSHomePage;
import com.ibm.icu.impl.duration.impl.Utils;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class iOSHomeSteps extends ScenarioSteps{
		
	iOSHomePage homePage;
	Logger logger = LoggerFactory.getLogger(Utils.class);
	
	@Step
	public void account() {
		homePage.click_Account();
	}
}
