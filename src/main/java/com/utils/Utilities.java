package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {
	
	public static String PropReader(String value) throws IOException {
		Properties p=new Properties();
		FileInputStream file=new FileInputStream(Constants.propertiespath);
		p.load(file);
		return p.getProperty(value);
	}
	
	public static void explicitwait(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public static String[][] getalldata(String sheetname) throws IOException {
		XSSFWorkbook book=new XSSFWorkbook(Constants.testdatapath);
	    XSSFSheet sheet=book.getSheet(sheetname);
	    int rows=sheet.getPhysicalNumberOfRows();
	    int cols=sheet.getRow(1).getPhysicalNumberOfCells();
	    String[][] data=new String[rows-1][cols];
	    for(int i=1;i<rows;i++)
	    {
	    	for(int j=0;j<cols;j++)
	    	{
	    		data[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
	    	}
	    }
	    return data;
	    
	}
	
	public static String getcelldata(String sheetname,int row,int cell) throws IOException
	
	{
		XSSFWorkbook book=new XSSFWorkbook(Constants.testdatapath);
	    XSSFSheet sheet=book.getSheet(sheetname);
	    String value=sheet.getRow(row).getCell(cell).getStringCellValue();
	    return value;
		
	}
	
	public static void moveactions(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.moveToElement(element).build().perform();
		
	}
	
	public static void draganddrop(WebDriver driver,WebElement src,WebElement target) {
		Actions a=new Actions(driver);
		a.dragAndDrop(src, target).release().build().perform();
	}
	
	public static boolean isalertpresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e) {
			return false;
		}
		
	}
	
	public static String getscreenshot(WebDriver driver,String testcasename) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String dest=System.getProperty("user.dir")+"\\Screenshots\\"+testcasename+".png";
		FileUtils.copyFile(src,new File(dest));
		return dest;
	}



}
