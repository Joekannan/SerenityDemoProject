package com.TWG.Mobile.Cucumber.StepDef;

import org.openqa.selenium.WebDriver;

import com.TWG.Mobile.steps.serenity.AddressSteps;
import com.TWG.Mobile.steps.serenity.CheckOutSteps;
import com.TWG.Mobile.steps.serenity.ClickAndCollectSteps;
import com.TWG.Mobile.steps.serenity.LoginSteps;
import com.TWG.Mobile.steps.serenity.SearchSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

public class CheckoutStepDef {
	
	public String cardNum = "4111 1111 1111 1111";
	public String name = "Test";
	public String code = "123";
	public String orderNum = "";
	
	@Managed(driver = "appium")
	WebDriver driver;
	
	@Steps
	LoginSteps loginSteps;
	@Steps
	SearchSteps searchSteps;
	@Steps
	CheckOutSteps checkOutSteps;
	@Steps
	AddressSteps addressSteps;
	@Steps
	ClickAndCollectSteps clickAndCollectSteps;
	
	
	
	@Given("^I login using \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_login_using_and(String email, String password) throws Throwable {
		loginSteps.click_menu();
		loginSteps.login();
		loginSteps.enterCredentials(email, password);
		loginSteps.signin();
	}

	@Given("^I look for \"([^\"]*)\"$")
	public void i_look_for(String text) throws Exception {
		searchSteps.SearchClick();
		searchSteps.SearchString(text);
		searchSteps.SearchResultClick();
	}

	@When("^I select \"([^\"]*)\" from the appropriate category$")
	public void i_select_from_the_appropriate_category(String arg1) throws Exception {
		checkOutSteps.selectProduct();
	}

	@When("^I select to add one of the items to the cart$")
	public void i_select_to_add_one_of_the_items_to_the_cart() throws Exception {
		checkOutSteps.addProducToCart();
	}

	@When("^I go to cart$")
	public void i_go_to_cart() throws Exception {
		checkOutSteps.fetchCart();
	}

	@When("^I select \"([^\"]*)\"$")
	public void i_select(String deliveryMethod) throws Exception {
	   checkOutSteps.updateDeliveryMethod(deliveryMethod);
	}

	@When("^I click Checkout$")
	public void i_click_Checkout() throws Exception {
		checkOutSteps.checkOut();
	}

	@Then("^I add the delivery details$")
	public void i_add_the_delivery_details() throws Exception {
		checkOutSteps.adddeliveryAddress();
		addressSteps.enterNewAddress();
		addressSteps.selectNewAddress();
		addressSteps.updateAddressDetails();
		addressSteps.saveAddressDetails();
		checkOutSteps.deliveryInstruction();
		checkOutSteps.enableSignature();
	    System.out.println("Delivery address details updated");
	}

	@Then("^I add Click and Collect details$")
	public void i_add_Click_and_Collect_details() {
		clickAndCollectSteps.pickYourStore();
		clickAndCollectSteps.updateContactDetails();
		System.out.println("Click and Collect details provided");  
	}

	@Then("^I select the \"([^\"]*)\"$")
	public void i_select_the(String paymentMethod) throws Exception {
		checkOutSteps.updatePaymentMethod(paymentMethod);
	}

	@Then("^I Click Payment button to enter the card details$")
	public void i_Click_Payment_button_to_enter_the_card_details() throws Exception {
		checkOutSteps.payment();
		checkOutSteps.updateCardDetails(cardNum, name, code);
		checkOutSteps.placeAnOrder();
	}

	@Then("^successful payment displays the order number$")
	public void successful_payment_displays_the_order_number() throws Exception {
		orderNum = checkOutSteps.retrieveOrderNumber();
	}
	@Then("^I Click Payment button to enter \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_Click_Payment_button_to_enter_and_and(String cardNum, String name, String code) {
		checkOutSteps.payment();
		checkOutSteps.updateCardDetails(cardNum, name, code);
	}

	@Then("^I Click Place order now$")
	public void i_Click_Place_order_now() {
		checkOutSteps.placeAnOrder();
	}
}
