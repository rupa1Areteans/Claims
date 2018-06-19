package com.cucumber.framework.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.framework.configreader.ObjectRepo;
import com.cucumber.framework.helper.Logger.LoggerHelper;
import com.cucumber.framework.helper.Wait.WaitHelper;


public class InteractionPage{
	
	   WebDriver driver;
	   WaitHelper waitHelper;
	   private final Logger log = LoggerHelper.getLogger(InteractionPage.class);
	
	@FindBy(xpath="//a[@title='Create New Interaction']")
	WebElement NewLink;
	
	@FindBy(xpath="//a/span[@class='menu-item-title-wrap']/span[contains(text(),'Inbound Call')]")
	WebElement phoneCallLink;
	
	@FindBy(xpath="//span[text()='Search for Customer']")
	WebElement phonecallLabelSearchForCustomer;
	
	public InteractionPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, NewLink,ObjectRepo.reader.getExplicitWait());
	}
	
	public void clickNew() {
		log.info("Clicking on New");
		waitHelper.waitForElement(driver,NewLink,5);
		NewLink.click();
	}

	public void clickPhoneCall() {
		log.info("Clicking on phonecall link");
		waitHelper.waitForElement(driver,phoneCallLink,5);
		phoneCallLink.click();
	}
	
	public void displayPhoneCallSearchHomePage() {
		//waitFor(2);
		clickNew();
		//waitFor(2);
		clickPhoneCall();
		//waitFor(2);
	}
	
	public boolean searchForCustomerLabel(){
		log.info("Verify search for customer label");
		waitHelper.waitForElement(driver,phoneCallLink,5);
		return phonecallLabelSearchForCustomer.isDisplayed();
	}
}
