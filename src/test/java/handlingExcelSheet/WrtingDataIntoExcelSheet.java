package handlingExcelSheet;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WrtingDataIntoExcelSheet {

	public static void main(String[] args) throws IOException {
		
		        FileOutputStream file = new FileOutputStream("C:\\Users\\ybhamare\\eclipse-workspace\\SeleniumNecessaryCodesPractice\\DataDriven\\myfile1.xlsx");
		        XSSFWorkbook workbook = new XSSFWorkbook();
		        XSSFSheet sheet=workbook.createSheet("Sheet1");
		        XSSFRow row0=sheet.createRow(0);
		        row0.createCell(1).setCellValue("Yuvraj");
		        row0.createCell(2).setCellValue("Pravin");
		        row0.createCell(3).setCellValue("Suraj");
		        
		        XSSFRow row1=sheet.createRow(1);
		        row1.createCell(1).setCellValue("100");
		        row1.createCell(2).setCellValue("200");
		        row1.createCell(3).setCellValue("300");
		        workbook.write(file);
		        
		    	workbook.write(file);
		    	workbook.close();
		    	file.close();
		        System.out.println("ExcelSheet Created Successfully");
	
	
	}

}
