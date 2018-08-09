package com.rave.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
	
	public TestBase() {
		
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\asus\\eclipse-workspace\\RaveDurlov\\src\\main\\java\\com\\rave\\qa\\config\\config.properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\Selenium_Drivers\\chromedriver_win32\\chromedriver.exe");
			
			//used ChromeOptions to disable info bar saying browser control by automated software
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			driver = new ChromeDriver(options);
			
			
			
//			//driver = new ChromeDriver();
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("-incognito");
//			options.addArguments("start-maximized");
//			DesiredCapabilities capabilities = DesiredCapabilities.chrome();    
//			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//			driver = new ChromeDriver(capabilities);
//			
		}
		else if (browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "F:\\Selenium_Drivers\\geckodriver-v0.21.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
	}

}
