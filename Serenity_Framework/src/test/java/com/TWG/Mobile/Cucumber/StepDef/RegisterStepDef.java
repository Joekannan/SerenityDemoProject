package com.TWG.Mobile.Cucumber.StepDef;

import org.openqa.selenium.WebDriver;

import com.TWG.Mobile.steps.serenity.RegistrationSteps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class RegisterStepDef {
	
	@Managed(driver = "appium")
	WebDriver driver;
	
	@Steps
	RegistrationSteps registrationStep;
	
	
	@When("^I click Register button$")
	public void click_Register_button() throws Exception {
		registrationStep.register();
	}

	@Then("^I land on the registration page$")
	public void land_on_the_registration_page() throws Exception {
	    
	}
	
	@Then("^I enter all required details for registration$")
	public void enter_rquired_details_for_registration() throws Exception {
		registrationStep.register_NewUser();
	}
	
	@Then("^I see the Registration Confirmation$")
	public void i_see_the_Registration_Confirmation() {
		registrationStep.register_Confirmation();
	}
}
