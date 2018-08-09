package com.rave.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.rave.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Web elements identify and store in web element type variable
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginButton;
	
	
	//To initialize all the above objects/web elements
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//method to get the title of the web page
	public String GetLoginPageTitle() {
		return driver.getTitle();
	}
	
//	public HomePage LoginAsUser(String un, String pwd ) {
//		username.sendKeys(un);
//		password.sendKeys(pwd);
//		Actions act = new Actions(driver);
//		act.moveToElement(loginButton).click().perform();
//		return new HomePage();
//	}
	
	public HomePage login(String un, String  pwd) throws InterruptedException {
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(5000);
		//LoginBtn.click();
		//return new HomePage();
		Actions actions = new Actions(driver);
		actions.moveToElement(loginButton).click().perform();
		return new HomePage();
	}
	
	
	
	

}
