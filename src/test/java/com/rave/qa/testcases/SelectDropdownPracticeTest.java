package com.rave.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rave.qa.base.TestBase;
import com.rave.qa.pages.SelectDropDownPage;

public class SelectDropdownPracticeTest extends TestBase{
	WebDriver driver;
	SelectDropDownPage selectDrop;
	
	public SelectDropdownPracticeTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		selectDrop = new SelectDropDownPage();
	}
	
	@Test
	public void selectFromDropDown() throws InterruptedException {
		
		System.out.println("-------Hi-------");
		Thread.sleep(5000);

		//this will select the day drop down by value
		selectDrop.selectByValue("3");
		
		//this will select the month drop down by index
		selectDrop.selectByIndex(4);
		
		//this will select the year drop down by visible text
		selectDrop.selectByVisibleText("2006");
		
		System.out.println("----bye-----");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
