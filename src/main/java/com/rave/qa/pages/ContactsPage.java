package com.rave.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rave.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
@FindBy(xpath="//select[@name='title']")
WebElement titleDropDown;

@FindBy(xpath="//input[@id='first_name']")
WebElement firstName;

@FindBy(xpath="//input[@id='middle_initial']")
WebElement middleName;

@FindBy(xpath="//input[@id='image_file']")
WebElement browseButton;

@FindBy(xpath="//input[@value='Save']")
WebElement saveButton;

@FindBy(xpath="//legend[contains(text(),'Contact Information')]")
WebElement newContactPageVerify;




public void selectCheckboxByName() {
	
	
}


}