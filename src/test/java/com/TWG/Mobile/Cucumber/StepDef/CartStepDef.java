package com.TWG.Mobile.Cucumber.StepDef;

import org.openqa.selenium.WebDriver;

import com.TWG.Mobile.steps.serenity.CartSteps;
import com.TWG.Mobile.steps.serenity.LoginSteps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

public class CartStepDef {
	
	@Managed(driver = "appium")
	WebDriver driver;

	
	@Steps
	CartSteps cartSteps;
	
	@When("^I click the remove deletes the item from a cart$")
	public void i_click_the_remove_deletes_the_item_from_a_cart() {
		cartSteps.removeFromCart();
	}

	@Then("^I will see the empty cart$")
	public void i_will_see_the_empty_cart() {
		cartSteps.emptyCartMsg();

	}
}
