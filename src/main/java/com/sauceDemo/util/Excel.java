package com.sauceDemo.util;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	public static XSSFSheet sheet(String sheetName) {
		try {
			FileInputStream f = new FileInputStream("data\\sauce.xlsx");
			XSSFWorkbook book = new XSSFWorkbook(f);
			XSSFSheet sheet = book.getSheet(sheetName);
			book.close();
			return sheet;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public static int nRow() {
		int rowNum = sheet("users").getPhysicalNumberOfRows();
		return rowNum;
	}
	
	public static int ncol() {
		int colNum = sheet("users").getRow(0).getLastCellNum();
		return colNum;
	}
	
	public static String cellValue(int row, int col) {
		XSSFSheet sheet = sheet("users");
		DataFormatter df = new DataFormatter();
		String value = df.formatCellValue(sheet.getRow(row).getCell(col));
		return value;
	}
}
