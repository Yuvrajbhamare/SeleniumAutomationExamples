package handlingExcelSheet;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HandlingExcelSheets {

	public static void main(String[] args) throws IOException {

		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\DataDriven\\SCAN-300.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int totalrows=sheet.getLastRowNum();
		int totalcells=sheet.getRow(1).getLastCellNum();
		System.out.println("No of rows:"+totalrows);
		System.out.println("No of cols:"+totalcells);
		
		for(int r=0;r<=totalrows;r++)
			
		{
			XSSFRow currentrows=sheet.getRow(r);
		
		for(int c=0;c<totalcells;c++)
		{
			XSSFCell allcells=currentrows.getCell(c);
			System.out.print(allcells.toString()+"\t");
		}
		System.out.println();
		
		}
	    workbook.close();
		file.close();
		
	}

}
		
		
		
		