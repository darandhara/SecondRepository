package com.rave.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;
import com.rave.qa.base.TestBase;


public class TestUtil extends TestBase{
	
	
	public static long PAGE_LOAD_TIMMEOUT = 30;
	public static long IMPLICIT_WAIT = 20;
	public static String TEST_DATA_SHEET_PATH = "C:\\Users\\asus\\eclipse-workspace\\RaveDurlov\\src\\main\\java\\com\\rave\\qa\\testdata\\TestData.xlsx";
	
	static Sheet sheet;
	static Workbook book;
	
	//this method use to switch to main frame when page having multiple frame
	public void SwitchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	
//	public static Object[][] getTestData(String sheetName) throws FileNotFoundException, InvalidFormatException{
//		
//		FileInputStream fis = null;
//		
//		try {
//			fis = new FileInputStream(TEST_DATA_SHEET_PATH);
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		try {
//			book = WorkbookFactory.create(fis);
//		} catch (InvalidFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		sheet = book.getSheet(sheetName);
//		int rowCount = sheet.getLastRowNum();
//		int columnCount = sheet.getRow(0).getLastCellNum();
//		
//		Object[][] data = new Object[rowCount][columnCount];
//		
//		for(int i=0; i<rowCount; i++) {
//			for(int j=0; j<columnCount; j++ ) {
//				
//				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
//			}
//		}
//		
//		return data;
//		
//	}
	
	public static Object[][] getTestData(String sheetName) throws FileNotFoundException, InvalidFormatException{
		FileInputStream file=null;
		try{
			//object creation and initialization with file path
			file=new FileInputStream("C:\\\\Users\\\\asus\\\\eclipse-workspace\\\\RaveDurlov\\\\src\\\\main\\\\java\\\\com\\\\rave\\\\qa\\\\testdata\\\\TestData.xlsx");
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
		try{
			book=WorkbookFactory.create(file);
		}catch (IOException e){
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++){
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++){
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
	}
	
	
	public void TakeScreenShot() throws IOException {
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File src = scrShot.getScreenshotAs(OutputType.FILE);
		File dest = new File( "./screenshot/" + System.currentTimeMillis() + ".png");
		Files.copy(src, dest);
	}
}
