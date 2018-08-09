package com.rave.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.rave.qa.base.TestBase;

public class NewContactsPage extends TestBase{
	
	@FindBy(xpath="//select[@name='title']")
	WebElement titleDropDown;

	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstName;

	@FindBy(xpath="//input[@id='middle_initial']")
	WebElement middleName;
	
	@FindBy(xpath="//input[@id='surname']")
	WebElement lastName;

	@FindBy(xpath="//input[@id='image_file']")
	WebElement browseButton;

	@FindBy(xpath="//input[@name='addmore']")
	WebElement saveButton;
	
//	@FindBy(xpath="//	@FindBy(xpath=\"//input[@name='addmore']\")\r\n" + 
//			"//	WebElement saveButton;")
//	WebElement saveButton;

	@FindBy(xpath="//legend[contains(text(),'Contact Information')]")
	WebElement newContactPageVerify;
	
	public NewContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyNewContactsPage() {
		return newContactPageVerify.isDisplayed();
		
	}
	
	
	public void creatNewContacts(String title, String fName, String mName, String lName, String uploadPath) {
		
		System.out.println("debug2");
		Select sel = new Select(titleDropDown);
		sel.selectByVisibleText(title);
		System.out.println("debug3");
		
		firstName.sendKeys(fName);
		
		middleName.sendKeys(mName);
		
		lastName.sendKeys(lName);
		
		browseButton.sendKeys(uploadPath);
		
		saveButton.click();
	}
	
	
	public void emptyContactErrorPoupHandle() throws InterruptedException {

		saveButton.click();
//		((JavascriptExecutor)driver).executeScript("arguments[0].click()", saveButton);
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
	}



}
