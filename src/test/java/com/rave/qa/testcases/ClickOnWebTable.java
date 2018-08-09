package com.rave.qa.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ClickOnWebTable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium_Drivers\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.freecrm.com/index.html");
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("naveenk");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("test@123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(5000);
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//a[@title='Contacts']")).click();
		
		Thread.sleep(5000);
		//List<WebElement> element = driver.findElements(By.xpath("//*[@id=\"vContactsForm\"]/table/tbody/tr"));
		//int count = element.size()-4;
		//System.out.println(count);
		
		
		String before = "//*[@id=\"vContactsForm\"]/table/tbody/tr[";
		String afterName = "]/td[2]";
		String afterCheckBox="]/td[1]/input";
		
		for(int i=4; i<=24; i++) {
			String text = driver.findElement(By.xpath(before+i+afterName)).getText();
			System.out.println(text);
			if(text.contains("abc abc")) {
				driver.findElement(By.xpath(before+i+afterCheckBox)).click();
				System.out.println(text);
				break;
			}
			
		}
		
		
		/*Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[@title='Contacts']"))).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'New Contact')]")).click();*/
		
		//driver.quit();

	}

}
