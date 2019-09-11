package com.phptravellDataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PhpTravellxlsxReader {


		public static String[][] returnLocator(String file) throws IOException {
			FileInputStream fileInput = new FileInputStream(file);// read the data present in xlsx file
			XSSFWorkbook book = new XSSFWorkbook(fileInput);
			org.apache.poi.ss.usermodel.Sheet sheet = book.getSheetAt(0);
			int row1 = sheet.getLastRowNum();
			row1 += 1;
			int col = sheet.getRow(0).getLastCellNum();
			String array[][] = new String[row1][col];
			int count = 0;
			for (Row row : sheet) {
			int count1 = 0;
			for (Cell cell : row) {
			String Data = cell.toString();
			array[count][count1] = Data;
			count1++;
			}
			count++;
			}
			return array;
			}

	/**
	 * @return
	 * @throws IOException
	 */
			@DataProvider(name="Read_data_Provider")
			public  String[][] getdata() throws IOException {
			   return PhpTravellxlsxReader.returnLocator("./src/test/resources/cheapticket_testData/test_data.xlsx");
			}
			
	}
	
	

