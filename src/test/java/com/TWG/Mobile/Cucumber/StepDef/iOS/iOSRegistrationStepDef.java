package com.TWG.Mobile.Cucumber.StepDef.iOS;

import org.openqa.selenium.WebDriver;

import com.TWG.Mobile.steps.serenity.iOS.iOSHomeSteps;
import com.TWG.Mobile.steps.serenity.iOS.iOSRegistrationSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

public class iOSRegistrationStepDef {
	@Managed(driver = "appium")
	WebDriver driver;

	
	@Steps
	iOSRegistrationSteps registrationSteps;
	
	@Steps
	iOSHomeSteps homeSteps;
	
	@Given("^I open the App$")
	public void i_open_the_App() {
	   System.out.println("App launched successfully.");
	}

	@When("^I click Account tab$")
	public void i_click_Account_tab() {
		homeSteps.account();
	}

	@When("^I click Register button on Account Page$")
	public void i_click_Register_button_on_Account_Page() {
		registrationSteps.register();
	}

	@Then("^I landed on the registration page$")
	public void i_landed_on_the_registration_page() {
		registrationSteps.registrationPage();
	}

	@Then("^I enter mandatory details for the registration$")
	public void i_enter_mandatory_details_for_the_registration() {
		registrationSteps.register_NewUser();
	}

	@Then("^I click REGISTER button$")
	public void i_click_REGISTER_button() {
		registrationSteps.register();
	}

	@Then("^I see the user is logged in$")
	public void i_see_the_user_is_logged_in() {
		registrationSteps.register_Confirmation();
	}
}
