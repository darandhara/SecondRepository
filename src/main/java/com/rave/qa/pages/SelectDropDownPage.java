package com.rave.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.rave.qa.base.TestBase;

public class SelectDropDownPage extends TestBase{
	
	@FindBy(id="day")
	WebElement day;
	
	@FindBy(id="month")
	WebElement month;
	
	@FindBy(id="year")
	WebElement year;
	
//	@FindBy(xpath="//input[@name='password']")
//	WebElement password;
//	
//	@FindBy(xpath="//input[@type='submit']")
//	WebElement loginButton;
	
	
	//To initialize all the above objects/web elements
	public SelectDropDownPage() {
		PageFactory.initElements(driver, this);
	}
	
	
//	//method to get the title of the web page
//	public String GetLoginPageTitle() {
//		return driver.getTitle();
//	}
//	
//	public HomePage LoginAsUser(String un, String pwd ) {
//		username.sendKeys(un);
//		password.sendKeys(pwd);
//		Actions act = new Actions(driver);
//		act.moveToElement(loginButton).click().perform();
//		return new HomePage();
//	}
	
//	public HomePage login(String un, String  pwd) {
//		username.sendKeys(un);
//		password.sendKeys(pwd);
//		//LoginBtn.click();
//		//return new HomePage();
//		Actions actions = new Actions(driver);
//		actions.moveToElement(loginButton).click().perform();
//		return new HomePage();
//	}
	
  public void selectByValue(String val) {
	  Select sel = new Select(day);
	  sel.selectByValue(val);
	}
  
  public void selectByIndex(int ind) {
	  Select sel = new Select(month);
	  sel.selectByIndex(ind);
  }
  
  
  public void selectByVisibleText(String txt) {
	  Select sel = new Select(year);
	  sel.selectByVisibleText(txt);
  }

}
