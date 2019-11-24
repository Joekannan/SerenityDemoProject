package com.TWG.Mobile.Cucumber.StepDef;

import org.openqa.selenium.WebDriver;

import com.TWG.Mobile.steps.serenity.SearchSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

//@RunWith(CucumberWithSerenity.class)
public class SearchStepDef {
	
	@Managed(driver = "appium")
	WebDriver driver;

	
	@Steps
	SearchSteps searchSteps;
	
	
	@Given("^I launch the AUT$")
	public void i_launch_the_AUT() throws Exception {
	    System.out.println("App launched successfully");
	}

	@When("^I click SearchButton$")
	public void i_click_SearchButton() throws Exception {
		searchSteps.SearchClick();
	}

	@Then("^I enter \"([^\"]*)\"$")
	public void i_enter(String text) throws Exception {
	   //text = "Rings";
	   searchSteps.SearchString(text);
	}

	@Then("^I click Find button$")
	public void i_click_Find_button() throws Exception {
		searchSteps.SearchResultClick();
	   System.out.println("Search performed");
	}
}
