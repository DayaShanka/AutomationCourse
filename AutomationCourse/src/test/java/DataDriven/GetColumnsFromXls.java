package DataDriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetColumnsFromXls {

	public static void main(String[] args) throws IOException {

		// reading the xls data
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\testdatafile\\testdata1.xlsx");
		// System.out.println("File path: " + System.getProperty("user.dir") +
		// "\\testdatafile\\tdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int totalCells = sheet.getRow(1).getLastCellNum();
		System.out.println("total no. of column count: " + totalCells);

		XSSFRow headerRow = sheet.getRow(0); // Retrieve only the first row (headers)
		int totalCell = headerRow.getLastCellNum();

		for (int c = 0; c < totalCell; c++) {
			XSSFCell cell = headerRow.getCell(c);
			System.out.print(cell.toString() + "\t" + "\t");
		}
		System.out.println();
	}

}
