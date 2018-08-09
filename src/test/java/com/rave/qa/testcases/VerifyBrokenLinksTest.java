package com.rave.qa.testcases;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class VerifyBrokenLinksTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium_Drivers\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		for(WebElement ele1 : links) {
			
			String li = ele1.getAttribute("href");
			System.out.println(li);
			verifyActiveLink(li);
		}

	}
	
	
	public static void verifyActiveLink(String verifyUrl) {
		
		try {
			URL url = new URL(verifyUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(3000);
			conn.connect();
			
			if(conn.getResponseCode()==200) {
				System.out.println(verifyUrl+"--"+conn.getResponseMessage());
			}
			if(conn.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(verifyUrl+"--"+HttpURLConnection.HTTP_NOT_FOUND);
				
			}
			
		} catch (Exception e) {
			
		};
	} 

}
