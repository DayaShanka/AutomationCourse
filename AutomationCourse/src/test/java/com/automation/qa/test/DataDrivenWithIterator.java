package com.automation.qa.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenWithIterator {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\testdatafile\\FDdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheetNumber = workbook.getNumberOfSheets();
		System.out.println("Number of sheets in the excel file: " + sheetNumber);

		for (int i = 0; i < sheetNumber; i++) {
			String sName = workbook.getSheetAt(i).getSheetName();
			System.out.println("Name of sheets: " + sName);
			if (sName.equals("Sheet2")) {
				String sheet = workbook.getSheetAt(i).getSheetName();
				System.out.println("selected sheet for testing: " + sheet);

			}

		}

		// XSSFSheet sheet = workbook.getSheet("Data"); //acces the directly sheet

	}

}
