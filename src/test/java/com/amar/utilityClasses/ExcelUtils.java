package com.amar.utilityClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	Workbook book;

	public String initExcelsheet(String sheet,int row ,int cell) {
		
		try {
			FileInputStream file=new FileInputStream("./src/test/resources/Excel_File/playwright_ExcelSheet.xlsx");
		    book=new XSSFWorkbook(file);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String dataName = book.getSheet(sheet).getRow(row).getCell(cell).toString();
		return dataName;
	}
}

