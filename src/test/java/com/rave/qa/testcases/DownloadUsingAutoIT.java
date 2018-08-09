package com.rave.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DownloadUsingAutoIT {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		Runtime.getRuntime().exec("C:\\Users\\asus\\Desktop\\AutoItScripts\\FileDownloadAutoIT.exe");
		Thread.sleep(5000);
		
	}

}
