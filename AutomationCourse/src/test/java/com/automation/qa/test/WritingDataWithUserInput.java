package com.automation.qa.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataWithUserInput {

	public static void main(String[] args) throws IOException {

		FileOutputStream file = new FileOutputStream(
				System.getProperty("user.dir") + "\\testdatafile\\myfiledynamicuserinput.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("DataDynamic");

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter how many rows you want (excluding header)?: ");
		int rowNumber = sc.nextInt();
		System.out.println("Enter how many columns you want?: ");
		int columnNumber = sc.nextInt();

		// Create header row
		XSSFRow headerRow = sheet.createRow(0);
		for (int c = 0; c < columnNumber; c++) {
			XSSFCell headerCell = headerRow.createCell(c);
			System.out.println("Enter name for column " + (c + 1) + ": ");
			headerCell.setCellValue(sc.next());
		}

		// Create data rows
		for (int r = 1; r <= rowNumber; r++) { // start from row 1 for data rows
			XSSFRow currentRow = sheet.createRow(r);
			for (int c = 0; c < columnNumber; c++) {
				XSSFCell currentCell = currentRow.createCell(c);
				System.out.println("Enter data for row " + r + ", column " + (c + 1) + ": ");
				currentCell.setCellValue(sc.next());
			}
		}

		workbook.write(file);
		workbook.close();
		file.close();
		sc.close();
		System.out.println("File created...");
	}
}
