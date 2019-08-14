package com.TWG.Mobile.steps.serenity;

import org.aspectj.weaver.Utils;
import org.eclipse.jetty.util.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.TWG.Mobile.pages.LoginPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class LoginSteps extends ScenarioSteps {

	LoginPage loginPage;
	
	Logger logger = LoggerFactory.getLogger(Utils.class);
	
	@Step
	public void click_menu() throws Throwable {
		loginPage.click_Menu();
	}
	@Step
	public void login() throws Throwable{
		loginPage.click_Login();
	}
	@Step
	public void enterCredentials(String username, String password) throws Throwable{
		loginPage.enter_UserName(username);
		loginPage.enter_Password(password);
	}
	
	@Step
	public void signin() throws Throwable{
		loginPage.click_Signin();	
	}
	
	@Step
	public void wait_HamBurger() throws Throwable{
		loginPage.waitForMenu();	
	}
	
	@Step
	public void failedLoginStatus() {
		String strStatus = loginPage.validate_LoginFailure();
		if(strStatus.equalsIgnoreCase("Login failed")) {
			logger.info(strStatus);
		}
		else {
			logger.info("Status Message - "+strStatus);
		}
		
	}
	
	@Step
	public void successLoginStatus() {
		String strStatus = loginPage.validate_LoginSuccess();
		if(strStatus.equalsIgnoreCase(loginPage.email)) {
			logger.info(strStatus);
		}
		else {
			logger.info("Status Message - "+strStatus);
		}
	}
}
