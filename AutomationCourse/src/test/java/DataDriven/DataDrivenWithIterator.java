package DataDriven;

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
			String allSheetNames = workbook.getSheetAt(i).getSheetName();
			System.out.println(allSheetNames);
			if (allSheetNames.equals("Sheet2")) {
				String selectedSheet = workbook.getSheetAt(i).getSheetName();
				System.out.println("selected sheet: " + selectedSheet);
			}

		}

		// XSSFSheet sheet = workbook.getSheet("Sheet2"); //acces the directly sheet

	}

}
