package com.TWG.Mobile.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;

public class AddressPage extends AppiumPageObject{

	public AddressPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "nz.co.thewarehouse.wow.qat:id/tv_address_search", timeoutInSeconds="10")
	public static WebElement txtAddressSearch;
	
	@FindBy(id = "nz.co.thewarehouse.wow.qat:id/tv_address", timeoutInSeconds="10")
	public List<WebElement> lstAddressResults;
	
	@FindBy(id = "nz.co.thewarehouse.wow.qat:id/enter_address_manually", timeoutInSeconds="10")
	public WebElement lnkEnterAddressManual;
	
	@FindBy(id = "nz.co.thewarehouse.wow.qat:id/first_name", timeoutInSeconds="10")
	public WebElement txtFirstName;
	
	@FindBy(id = "nz.co.thewarehouse.wow.qat:id/last_name", timeoutInSeconds="10")
	public WebElement txtLastName;
	
	@FindBy(id = "nz.co.thewarehouse.wow.qat:id/email", timeoutInSeconds="10")
	public WebElement txtEmail;
	
	@FindBy(id = "nz.co.thewarehouse.wow.qat:id/contact_number", timeoutInSeconds="10")
	public WebElement txtContactNum;
	
	@FindBy(id = "nz.co.thewarehouse.wow.qat:id/company_name", timeoutInSeconds="10")
	public WebElement txtCompanyName;
	
	@FindBy(id = "nz.co.thewarehouse.wow.qat:id/building", timeoutInSeconds="10")
	public WebElement txtBuilding;
	
	@FindBy(id = "nz.co.thewarehouse.wow.qat:id/street", timeoutInSeconds="10")
	public WebElement txtAddress;
	
	@FindBy(id = "nz.co.thewarehouse.wow.qat:id/suburb", timeoutInSeconds="10")
	public WebElement txtSuburb;
	
	@FindBy(id = "nz.co.thewarehouse.wow.qat:id/city", timeoutInSeconds="10")
	public WebElement txtCity;
	
	@FindBy(id = "nz.co.thewarehouse.wow.qat:id/postcode", timeoutInSeconds="10")
	public WebElement txtPostcode;
	
	@FindBy(id = "nz.co.thewarehouse.wow.qat:id/btn_save", timeoutInSeconds="10")
	public WebElement btnSavetop;
	
	@FindBy(id = "nz.co.thewarehouse.wow.qat:id/btn_save_big", timeoutInSeconds="10")
	public WebElement btnSavebottom;
	
//############################################################################################################
//Function Name:		enterNewDeliveryAddress 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to enter the new delivery addresses
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	
	public void enterNewDeliveryAddress() {
		try {
			if(isElementPresent(txtAddressSearch)) {
				String address = numGenerator(3);
				typeInto(txtAddressSearch, address+"/");
			}
			waitFor(10000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
//############################################################################################################
//Function Name:		selectDeliveryAddressfromList 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to select one of the listed delivery addresses
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	
	public void selectDeliveryAddressfromList() {
		try {
			int leng = lstAddressResults.size();
			if(leng >= 1) {
				for(WebElement lstAddressResult : lstAddressResults) {
					clickOn(lstAddressResult);
					break;
				}
				waitFor(5000);
			}
			else {
				if(isElementPresent(lnkEnterAddressManual)) {
					clickOn(lnkEnterAddressManual);
				}
			}
			waitFor(5000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
//############################################################################################################
//Function Name:		updateDeliveryAddress 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to update the contact details in created/selected address
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	
	public void updateDeliveryAddress() {
		try {
			if(isElementPresent(txtFirstName)) {
				typeInto(txtFirstName, nameGenrator());
			}
			else{
				System.out.println("No option to enter first name.");
			}
			if(isElementPresent(txtLastName)) {
				typeInto(txtLastName, nameGenrator());
			}
			else{
				System.out.println("No option to enter last name.");
			}
			if(isElementPresent(txtContactNum)) {
				typeInto(txtContactNum, "02"+numGenerator(7));
			}
			else{
				System.out.println("No option to enter contact number.");
			}
			if(isElementPresent(txtCompanyName)) {
				typeInto(txtCompanyName, "The Test Company");
			}
			else{
				System.out.println("No option to enter company name.");
			}
			if(isElementPresent(txtCompanyName)) {
				typeInto(txtCompanyName, "The Test Company");
			}
			else{
				System.out.println("No option to enter company name.");
			}
			
			if(txtBuilding.isEnabled()) {
				typeInto(txtBuilding, "Flat"+numGenerator(3));
			}
//			else{
//				System.out.println("No option to enter flat/building name.");
//			}
			if(txtAddress.isEnabled()) {
				typeInto(txtAddress, numGenerator(2)+" A Testing " +nameGenrator() );
			}
//			else{
//				System.out.println("No option to enter address.");
//			}
			if(txtSuburb.isEnabled()) {
				typeInto(txtSuburb, nameGenrator());
			}
//			else{
//				System.out.println("No option to enter suburb.");
//			}
			if(txtCity.isEnabled()) {
				typeInto(txtCity, "Auckland");
			}
//			else{
//				System.out.println("No option to enter City.");
//			}
			if(txtPostcode.isEnabled()) {
				typeInto(txtPostcode, numGenerator(4));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
//############################################################################################################
//Function Name:		saveDeliveryAddress 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to enter the new delivery addresses
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	
	public void saveDeliveryAddress() {
		try {
			if(isElementPresent(btnSavetop)) {
				clickOn(btnSavetop);
			}
			wait(20000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
