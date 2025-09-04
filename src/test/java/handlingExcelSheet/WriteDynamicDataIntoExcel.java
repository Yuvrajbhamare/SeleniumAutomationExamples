package handlingExcelSheet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDynamicDataIntoExcel {

	public static void main(String[] args) throws IOException {
		FileOutputStream file = new FileOutputStream(
				"C:\\Users\\ybhamare\\eclipse-workspace\\SeleniumNecessaryCodesPractice\\DataDriven\\DynamicFile.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("DynamicSheet");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("How Many Rows?");

		int noOfRows = sc.nextInt();

		System.out.println("How Many Columns?");

		int noOfCols = sc.nextInt();

		for (int r = 0; r <= noOfRows; r++) {
			XSSFRow currentrow = sheet.createRow(r);
			for (int c = 0; c < noOfCols; c++) {
				XSSFCell Cell = currentrow.createCell(c);
				Cell.setCellValue(sc.next());
			}
			workbook.write(file);
			workbook.close();
			file.close();
		}

	}

}
