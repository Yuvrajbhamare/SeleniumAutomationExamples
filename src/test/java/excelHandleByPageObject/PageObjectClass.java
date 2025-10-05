package excelHandleByPageObject;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PageObjectClass

{
	public static FileInputStream fi;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String xlfile, String xlSheet) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(xlSheet);
		int rowcount = sheet.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;

	}

	public static int getCellCount(String xlfile, String xlSheet, int rownum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(xlSheet);

		row = sheet.getRow(rownum);

		int CellCount = row.getLastCellNum();
		wb.close();
		fi.close();
		return CellCount;

	}

	public static String getCellData(String xlfile, String xlSheet, int rownum, int colnum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(xlSheet);

		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);

		String Data;

		Data = cell.toString();
		return Data;

	}
}
