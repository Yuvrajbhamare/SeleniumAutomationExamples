package handlingExcelSheet;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDynamicDataIntoSpecificCell {

	public static void main(String[] args) throws IOException {
		FileOutputStream file = new FileOutputStream(
				System.getProperty("user.dir") + "\\DataDriven\\DynamicDataIntoCell.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Dynamicsheet2");
		XSSFRow rows = sheet.createRow(4);

		XSSFCell cell = rows.createCell(3);
		cell.setCellValue("204");

		workbook.write(file);
		workbook.close();
		file.close();
		System.out.println("File is created");

	}

}
