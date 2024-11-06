package com.automation.qa.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetDataFromXls {

	public static void main(String[] args) throws IOException {

//Excel file-->workbook-->sheets-->rows-->cell

		// reading the xls data
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\testdatafile\\testdata1.xlsx");
		// System.out.println("File path: " + System.getProperty("user.dir") +
		// "\\testdatafile\\tdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int totalRows = sheet.getLastRowNum();
		int totalCells = sheet.getRow(1).getLastCellNum();
		System.out.println("total no. of rows count: " + totalRows);
		System.out.println("total no. of column count: " + totalCells);
		for (int r = 0; r <= totalRows; r++) {
			XSSFRow currentRow = sheet.getRow(r);
			for (int c = 0; c < totalCells; c++) {
				XSSFCell currentCell = currentRow.getCell(c);
				System.out.print(currentCell.toString() + "\t" + "\t" + "\t");

			}
			System.out.println();
		}
		workbook.close();
		file.close();
	}

}
