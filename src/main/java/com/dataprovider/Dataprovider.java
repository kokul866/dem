package com.dataprovider;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.utils.Utilities;

public class Dataprovider {

	
		@DataProvider(name="logdata")
		public String[][] data() throws IOException {
			String[][] data=Utilities.getalldata("Sheet1");
			return data;
			
		}
}
