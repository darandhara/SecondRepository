package com.rave.qa.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ScrollUsingJavaScript {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium_Drivers\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");
		
		Thread.sleep(5000);
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		WebElement ele = driver.findElement(By.xpath("//div[@id='mCSB_3_container']//p[contains(text(),'Neque porro quisquam est, qui dolorem ipsum quia d')]"));
		
		js.executeScript("arguments[0].scrollIntoView(true);",ele);
		
		String txt = ele.getText();
		
		System.out.println(txt);
	}
}
