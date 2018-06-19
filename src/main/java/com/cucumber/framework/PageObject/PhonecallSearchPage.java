package com.cucumber.framework.PageObject;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.framework.configreader.ObjectRepo;
import com.cucumber.framework.helper.Logger.LoggerHelper;
import com.cucumber.framework.helper.Wait.WaitHelper;


public class PhonecallSearchPage {

	 WebDriver driver;
	 WaitHelper waitHelper;
	 private final Logger log = LoggerHelper.getLogger(PhonecallSearchPage.class);
	
	@FindBy(xpath="//input[@id='SearchStringAcctNum']")
	WebElement AccountNumbertextfield;
	
	@FindBy(xpath="//button[@name='CPMFindCustomer_pyWorkPage_6' and contains(text(),'Search')]")
	WebElement Searchbutton;
	
	@FindBy(xpath="//tr[contains(@oaargs,'PegaFS-Data-Party-Ind')]")
	WebElement Row;
	
	
	@FindBy(xpath="//div[@class='pzbtn-mid' and text()='Submit']")
	WebElement SubmitButton;
	
	public PhonecallSearchPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, AccountNumbertextfield,ObjectRepo.reader.getExplicitWait());
	}
	
	public void sendTextToAccNum(String AccountNumber) {
		log.info("Entering AccountNumber");
		AccountNumbertextfield.sendKeys(AccountNumber);
	}
	
	public void clickOnSearchButton() {
		waitHelper.waitForElement(driver,Searchbutton,5);
		Searchbutton.click();
	}
	
	public void clickRow(String producttypevalue) {
		//driver.switchTo().defaultContent();
		//waitForElement(Row,5);
		//Row.click();
		List<WebElement> rows=driver.findElements(By.xpath("//tr[contains(@oaargs,'PegaFS-Data-Party-Ind')]"));
		//rows.get(0).click();
		System.out.println(rows.size());
		for(int i=0;i<rows.size();i++) {
		System.out.println(rows.get(i).getText());
		////span[@data-test-id='20170725121642024593327']-old xpath
		List<WebElement> columns=driver.findElements(By.xpath("//td[@data-attribute-name='Product Type']"));
		System.out.println(columns.size());
		for(int j=0;j<columns.size();j++) {
			System.out.println(columns.get(j).getText());
			try {
			String producttype=columns.get(j).getText();
			if(producttype.equalsIgnoreCase(producttypevalue)) {
				//waitFor(3);
				columns.get(j).click();
				break;
			}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	}
	
	/*public void clickSubmit() {
		//switchToFrame("PegaGadget1Ifr");
		waitForElement(SubmitButton,2);
		SubmitButton.click();
		waitFor(5);
	}
	
	public void phonecallSearch(String AccNum) {
		//getFrames();
		String frame=goToFrame(AccountNumbertextfield);
	    System.out.println("Actual frame where element present is"+frame);
		sendTextToAccNum(AccNum);
		clickOnSearchButton();
		clickRow("loan");
		waitFor(5);
		clickSubmit();
		
	}
	
	public void selectRow(String productvalue) {
		clickRow(productvalue);
		waitFor(2);
		clickSubmit();
	}
	*/
}
