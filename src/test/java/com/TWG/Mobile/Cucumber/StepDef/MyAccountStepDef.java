package com.TWG.Mobile.Cucumber.StepDef;

import org.openqa.selenium.WebDriver;

import com.TWG.Mobile.steps.serenity.CartSteps;
import com.TWG.Mobile.steps.serenity.MyAccountSteps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

public class MyAccountStepDef {

	@Managed(driver = "appium")
	WebDriver driver;

	
	@Steps
	MyAccountSteps myAccountSteps;
	

	@When("^I click My Account$")
	public void i_click_My_Account() {
		try {
			myAccountSteps.clickMyAccount();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Then("^I see list of options under My Account$")
	public void i_see_list_of_options_under_My_Account() {
		try {
			myAccountSteps.validateMyAccount();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
}
