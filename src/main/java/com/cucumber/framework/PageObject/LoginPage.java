package com.cucumber.framework.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.framework.configreader.ObjectRepo;
import com.cucumber.framework.helper.Logger.LoggerHelper;
import com.cucumber.framework.helper.Wait.WaitHelper;


public class LoginPage {
	
      WebDriver driver;
      WaitHelper waitHelper;
    private final Logger log = LoggerHelper.getLogger(LoginPage.class);
      
	
	@FindBy(xpath="//input[@id='txtUserID']")
	WebElement usernametext;
	
	@FindBy(xpath="//input[@id='txtPassword']")
	WebElement passwordtext;
	
	@FindBy(xpath="//button[@id='sub']")
	WebElement lognbtn;
	
	@FindBy(xpath="//div[@class='pzbtn-mid' and text()='Close']")
	WebElement loginclosebtn;
	
	@FindBy(xpath="//a[contains(text(),'CS Inbound Officer')]")
	WebElement WelcomeUser;
	
	@FindBy(xpath="//div[@id='error' and contains(text(),'The information you entered was not recognized.')]")
	WebElement informationWrongMsg;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, usernametext,ObjectRepo.reader.getExplicitWait());
	}
	
	
	public void setUserName(String uname) {
		log.info("Entering user name");
	    usernametext.sendKeys(uname);
	}
	
	public void setPassword(String password) {
		log.info("Entering user password");
		passwordtext.sendKeys(password);
	}

	public void clickOnLogin() {
		log.info("Clicking on login");
		waitHelper.waitForElement(driver,lognbtn,5);
		lognbtn.click();
	}
	public boolean welcomeUserMsg(){
		waitHelper.waitForElement(driver,WelcomeUser,5);
		return WelcomeUser.isDisplayed();
	}
	
	public boolean informationWrongMsg(){
		waitHelper.waitForElement(driver,informationWrongMsg,5);
		return informationWrongMsg.isDisplayed();
	}

}
