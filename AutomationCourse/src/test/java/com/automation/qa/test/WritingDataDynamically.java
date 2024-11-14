package com.automation.qa.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataDynamically {

	public static void main(String[] args) throws IOException {

		FileOutputStream file = new FileOutputStream(
				System.getProperty("user.dir") + "\\testdatafile\\myfiledynamic.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("DataDynamic");

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter how many rows you want?: ");
		int rowNumber = sc.nextInt();
		System.out.println("Enter how many cells you want?: ");
		int cellslNumber = sc.nextInt();

		for (int r = 0; r <= rowNumber; r++) {
			XSSFRow currentRow = sheet.createRow(r);
			for (int c = 0; c < cellslNumber; c++) {
				XSSFCell currentCells = currentRow.createCell(c);
				currentCells.setCellValue(sc.next());
			}
		}

		workbook.write(file);
		workbook.close();
		file.close();
		System.out.println("File created...");

	}

}
