package com.util;

import java.io.*;

import org.testng.annotations.DataProvider;

import jxl.*;
import jxl.read.biff.BiffException;

public class ExcelData {
	

	public Object[][] readExcel() throws BiffException, IOException{
		File f = new File("/Users/shruti/Documents/workspace/SutterHealth/Resource/inputData.xls");
		Workbook w = Workbook.getWorkbook(f);
		//Sheet sheet = w.getSheet(0);
		Sheet sheet = w.getSheet("login");
		int rows = sheet.getRows();
		int cols = sheet.getColumns();
		
		System.out.println(rows);
		System.out.println(cols);
		
		String inputData[][] = new String[rows][cols];
		 for(int i =1;i<rows;i++){
			 for(int j=0;j<cols;j++){
				 Cell cell =sheet.getCell(j,i);
				 inputData[i][j] = cell.getContents();
				 System.out.println(inputData[i][j]);
		 }
		
	}
		 return inputData;

	}
}
