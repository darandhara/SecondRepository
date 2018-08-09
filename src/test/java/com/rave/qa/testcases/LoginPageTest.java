package com.rave.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rave.qa.base.TestBase;
import com.rave.qa.pages.LoginPage;
import com.rave.qa.util.TestUtil;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	TestUtil testUtil;
	Logger log = Logger.getLogger(LoginPageTest.class);
	
	//constructor will call the parent call constructor using super
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		log.info("Object initialization happend");
		testUtil = new TestUtil();
		loginpage = new LoginPage();
	}
	
	//@Test(retryAnalyzer = Analyzer.RetryAnalyzer.class)
	@Test
	public void validateLoginPageTitle() {
		log.warn("Going to validate the page title");
		String str = loginpage.GetLoginPageTitle();
		Assert.assertEquals(str, "Free CRM software in the cloud powers sales and customer service1");
	}
	
//	@Test
//	public void loginTest() {
//		loginpage.LoginAsUser(prop.getProperty("username"), prop.getProperty("password"));
//	}
	
	@Test
	public void loginTest() throws InterruptedException {
		Thread.sleep(5000);
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
