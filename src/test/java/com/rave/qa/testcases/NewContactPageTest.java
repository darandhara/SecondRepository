package com.rave.qa.testcases;

import java.io.FileNotFoundException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rave.qa.base.TestBase;
import com.rave.qa.pages.HomePage;
import com.rave.qa.pages.LoginPage;
import com.rave.qa.util.TestUtil;
import com.rave.qa.pages.NewContactsPage;

public class NewContactPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	NewContactsPage newContactsPage;
	
	public NewContactPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		testUtil = new TestUtil();
		newContactsPage = new NewContactsPage();
		
		
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(5000);
		testUtil.SwitchToFrame();
		newContactsPage=homePage.clickOnNewContactsDD();
	}
	
//	@DataProvider
//	public Object[][] testDataProvider() throws FileNotFoundException, InvalidFormatException{
//		Object data[][] = TestUtil.getTestData("Sheet1");
//		return data;
//	}
//	
//	
//	@Test(dataProvider="testDataProvider")
//	public void createNewContactTest(String title, String firstName, String middleName, String lastName, String fileUploadPath ) {
//		newContactsPage.creatNewContacts(title, firstName, middleName, lastName,fileUploadPath);
//		
//	}
//	
	
//	@Test
//	public void createNewContactsTest() {
//		System.out.println("debug");
//		newContactsPage.creatNewContacts("Mr.", "Arjun", "Rampal", "Actor", "C:\\Users\\asus\\Pictures\\Saved Pictures\\2018-4k-playerunknowns-battlegrounds-c0.jpg");
//	}
	
	
	@Test()
	public void emptyCreateContactsPopupTest() throws InterruptedException {
		newContactsPage.emptyContactErrorPoupHandle();
	}

}
