package com.cucumber.framework.stepdefinition.login;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.cucumber.framework.PageObject.LoginPage;
import com.cucumber.framework.configreader.ObjectRepo;
import com.cucumber.framework.helper.Logger.LoggerHelper;
import com.cucumber.framework.helper.TestBase.TestBase;

import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login   {
	private final Logger log = LoggerHelper.getLogger(Login.class);
    
	LoginPage loginpage;

	
	@Given("^navigate to application$")
	public void navigate_to_application() throws Throwable {
		System.out.println(TestBase.getDriver());
		 TestBase.getDriver().get(ObjectRepo.reader.getWebsite());
		
	}

	@When("^enter username as \"([^\"]*)\"$")
	public void enter_username_as(String arg1) throws Throwable {
		loginpage= new LoginPage(TestBase.getDriver());
	loginpage.setUserName(arg1);
	

	}


	@When("^enter password as \"([^\"]*)\"$")
	public void enter_password_as(String arg1) throws Throwable {
		loginpage.setPassword(arg1);
	}

	@When("^click on login button$")
	public void click_on_login_button() throws Throwable {
	  loginpage.clickOnLogin();
	}

	@Then("^Login is successful$")
	public void login_is_successful() throws Throwable {
		if(loginpage.welcomeUserMsg()){
			log.info("login test is pass");
		}
		else{
			Assert.assertTrue(false, this.getClass().getSimpleName()+" is fail");
		}
	}
	
	@Then("^Login should not be successful$")
	public void login_should_not_be_successful() throws Throwable {
		if(loginpage.informationWrongMsg()){
			log.info("login test is pass");
		}
		else{
			Assert.assertTrue(false, this.getClass().getSimpleName()+" is fail");
		}
	}   


}
