package com.sauceDemo.util;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	@DataProvider
	public Object[][] loginData(){
		Object[][] data = new Object[1][2];
		data[0][0] = "standard_user";
		data[0][1] = "secret_sauce";
		return data; 
	}
	
	@DataProvider
	public Object[][] excelData(){
		int r = Excel.nRow();
		int c = Excel.ncol();
		Object[][] data = new Object[r-1][c];
		for(int i=0; i<r-1; i++) {
			for(int j=0; j<c; j++) {
				data[i][j] = Excel.cellValue(i+1, j);
			}
		}
		return data;
		
	}
}
