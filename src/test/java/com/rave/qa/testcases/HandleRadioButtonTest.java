package com.rave.qa.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleRadioButtonTest {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium_Drivers\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
		
		Thread.sleep(5000);
		
		List<WebElement> radio1 = driver.findElements(By.xpath("//input[@type='radio' and @name='lang']"));
		
		for(WebElement ele1 : radio1) {
			
			String str = ele1.getAttribute("value");
			
			if(str.equalsIgnoreCase("Python")) {
				ele1.click();
			}	
		}
		
		
		List<WebElement> checkbox1 = driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		for(WebElement ele2 : checkbox1) {
			String txt2 = ele2.getAttribute("id");
			if(txt2.equalsIgnoreCase("code")) {
				ele2.click();
			}
		}
		
		
		
	}
}
