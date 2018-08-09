package com.rave.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rave.qa.base.TestBase;

public class HomePage extends TestBase{
	
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsTab;
	
	@FindBy(xpath="//a[contains(text(), 'New Contact')]")
	WebElement newContactDD;




public HomePage() {
	PageFactory.initElements(driver, this);
}


public ContactsPage clickOnContactLink() {
	contactsTab.click();
	return new ContactsPage();
}


public NewContactsPage clickOnNewContactsDD() {
	Actions act = new Actions(driver);
	act.moveToElement(contactsTab).build().perform();
	newContactDD.click();
	return new NewContactsPage();
	
}



}
