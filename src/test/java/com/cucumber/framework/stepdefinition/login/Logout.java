package com.cucumber.framework.stepdefinition.login;

import org.apache.log4j.Logger;

import com.cucumber.framework.PageObject.InteractionPage;
import com.cucumber.framework.PageObject.LogoutPage;
import com.cucumber.framework.configreader.ObjectRepo;
import com.cucumber.framework.helper.Logger.LoggerHelper;
import com.cucumber.framework.helper.TestBase.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Logout  {
	
	private final Logger log = LoggerHelper.getLogger(Logout.class);
	
	LogoutPage logoutpage;
	InteractionPage ipage;
	
	
    @Given("^user should logout$")
    public void user_should_logout() throws Throwable {
    	
    	logoutpage=new LogoutPage(TestBase.getDriver());
    	logoutpage.logout();
   
     }
    
    @Given("^user clicks on New menu link$")
    public void user_clicks_on_New_menu_link() throws Throwable {
        ipage=new InteractionPage(TestBase.getDriver());
        ipage.clickNew();
    }

    @Then("^user clicks on inbound call link$")
    public void user_clicks_on_inbound_call_link() throws Throwable {
        ipage.clickPhoneCall();
    }


	
 }
