package com.automation.qa.test;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataFromXls {

	public static void main(String[] args) throws IOException {
		// writing the data in xlsx
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\testdatafile\\myfile.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Data");

		// creating the rowHeader from 0 index
		XSSFRow headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("Program"); // Column header
		headerRow.createCell(1).setCellValue("ID");
		headerRow.createCell(2).setCellValue("Course");

		// creating the rowCell from 1 index
		XSSFRow row1 = sheet.createRow(1);
		row1.createCell(0).setCellValue("java"); // creating index wise cell and input cellValue
		row1.createCell(1).setCellValue("12345");
		row1.createCell(2).setCellValue("automation");
		// creating the row from 2 index
		XSSFRow row2 = sheet.createRow(2);
		row2.createCell(0).setCellValue("python");
		row2.createCell(1).setCellValue("123456");
		row2.createCell(2).setCellValue("selenium");
		// creating the row from 3 index
		XSSFRow row3 = sheet.createRow(3);
		row3.createCell(0).setCellValue("javascript");
		row3.createCell(1).setCellValue("1234567");
		row3.createCell(2).setCellValue("angular");

		XSSFRow row4 = sheet.createRow(4);
		row4.createCell(0).setCellValue("node");
		row4.createCell(1).setCellValue("12345678");
		row4.createCell(2).setCellValue("api");

		int noOfColumnCount = sheet.getRow(0).getLastCellNum();
		System.out.println("Number of row count: " + noOfColumnCount);

		// Writes the entire workbook (containing your sheet, headers, and data rows) to
		// the file.
		workbook.write(file);

		workbook.close();
		file.close();
		System.out.println("File Created...");
	}

}
