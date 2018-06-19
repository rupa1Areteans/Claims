package com.cucumber.framework.PageObject;



import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.framework.configreader.ObjectRepo;
import com.cucumber.framework.helper.Logger.LoggerHelper;
import com.cucumber.framework.helper.Robot.RobotHelper;
import com.cucumber.framework.helper.Wait.WaitHelper;


public class LogoutPage {
		
WebDriver driver;
WaitHelper waitHelper;


private final Logger log = LoggerHelper.getLogger(LogoutPage.class);
	
	@FindBy(xpath="//i[@class='pi pi-caret-down']")
	WebElement usernamelink;
	
	@FindBy(xpath="//a//span[contains(text(),'Logout')]")
	WebElement logoutLink;
	
	public LogoutPage (WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, usernamelink,ObjectRepo.reader.getExplicitWait());
	}
	
	public void clickUser() {
		log.info("Clicking on caret link");
		waitHelper.waitForElement(driver,usernamelink,5);
		usernamelink.click();
	}
	
	public void clickLogout() {
		log.info("Clicking on logout");
		waitHelper.waitForElement(driver,logoutLink,5);
		logoutLink.click();
	}
	
	public void logout() {
		driver.switchTo().defaultContent();
		clickUser();
        clickLogout();
	    RobotHelper.robotClass();
	  }
	
	
	

}
