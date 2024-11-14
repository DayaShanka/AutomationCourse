package com.automation.qa.base;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetRowsFromXls {

	public static void main(String[] args) throws IOException {

		// reading the xls data
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\testdatafile\\testdata1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		int totalRows = sheet.getLastRowNum();

		System.out.println("Data from all rows (excluding headers):");
		for (int r = 1; r <= totalRows; r++) { // Start from row 1 to skip headers
			XSSFRow currentRow = sheet.getRow(r);
			if (currentRow != null) {
				int totalCells = currentRow.getLastCellNum();
				for (int c = 0; c < totalCells; c++) {
					XSSFCell currentCell = currentRow.getCell(c);
					System.out.print((currentCell != null ? currentCell.toString() : "") + "\t" + "\t");
				}
				System.out.println();
			}
		}

		workbook.close();
		file.close();
	}
}
