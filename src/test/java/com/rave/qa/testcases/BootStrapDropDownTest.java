package com.rave.qa.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BootStrapDropDownTest {
	
	public static void main(String[] args) throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver", "F:\\Selenium_Drivers\\chromedriver_win32\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("disable-infobars");
	WebDriver driver = new ChromeDriver(options);
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.get("http://seleniumpractise.blogspot.in/2016/08/bootstrap-dropdown-example-for-selenium.html");
	
	Thread.sleep(5000);
	
	//it will click on the drop down option 
	driver.findElement(By.xpath("//button[@id='menu1']")).click();
	Thread.sleep(5000);
	
	//Storing all the web elements in the drop down list into List
	List<WebElement> dd_menu = driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li/a"));
	
	//rendering throughr each element of the List
	for(WebElement ele : dd_menu) {
		
		//Storing each web element visible text 
		String names = ele.getAttribute("innerHTML");
		//System.out.println(names);
		
		
		//checking if the string of the web element equals to Javascript then click
		if(names.equalsIgnoreCase("JavaScript")) {
			System.out.println(names);
			//ele.click();
			Thread.sleep(5000);
			
			//this will scroll the scroll bar
			((JavascriptExecutor)driver).executeScript("scroll(0,400)");
		}
		
	}
//	Thread.sleep(5000);
//	((JavascriptExecutor)driver).executeScript("Scroll(0,400");
	
	}

}
