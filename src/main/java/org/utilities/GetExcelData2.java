package org.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetExcelData2 {
	
	
	@DataProvider(name= "getData")
	public Object[][] getData() throws IOException{
		File exceFile = new File(".\\ExcelFiles\\Data Provider.xlsx"); 
		FileInputStream fis = new FileInputStream(exceFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet s1 = workbook.getSheet("DataProvider");
		int noOfRows  = s1.getPhysicalNumberOfRows();
		int noOfColumns  = s1.getRow(0).getLastCellNum();
		
		Object [][] data = new Object[noOfRows-1][noOfColumns];
		
		for(int i=0 ;i<noOfRows-1 ;i++) {
			for(int j=0 ;j<noOfColumns;j++) {
				
				DataFormatter df = new DataFormatter();  //it will convert any type of data into String type
				
				data[i][j] = df.formatCellValue(s1.getRow(i+1).getCell(j));
				
			
				
			}
		}
		
		workbook.close();
		fis.close();
		
//		for(Object arr:data) {
//			System.out.println(arr.toString(data));    //it will print the data not the object
//		}
		return data;
		
	}
	


}